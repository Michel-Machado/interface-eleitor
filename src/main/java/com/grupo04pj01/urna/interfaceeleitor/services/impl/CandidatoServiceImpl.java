package com.grupo04pj01.urna.interfaceeleitor.services.impl;

import com.grupo04pj01.urna.interfaceeleitor.DTO.BuscaCandidatoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.CandidatoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.EnvioVotoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.ResponseLiberacaoUrnaDTO;
import com.grupo04pj01.urna.interfaceeleitor.services.CandidatoService;
import com.grupo04pj01.urna.interfaceeleitor.services.VotarService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CandidatoServiceImpl implements CandidatoService {


    private final RestTemplate restTemplate;

    @Override
    public Boolean verificarStatusUrna() {
        ResponseEntity<ResponseLiberacaoUrnaDTO> resposta= restTemplate.getForEntity("http://localhost:8080/liberacao_urna",ResponseLiberacaoUrnaDTO.class);
        ResponseLiberacaoUrnaDTO bodyResposta= resposta.getBody();
        return bodyResposta.getIsUrnaLiberada();
    }

    @Override
    public CandidatoDTO findCandidato(BuscaCandidatoDTO buscaCandidatoDTO) {
        String url = "http://localhost:8080/candidato/" + buscaCandidatoDTO.getChapa().toString();
        JSONObject body= new JSONObject();
        body.put("chapa",buscaCandidatoDTO.getChapa());

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(body.toString(),httpHeaders);

        ResponseEntity<CandidatoDTO> busca= restTemplate.postForEntity(url, requestEntity, CandidatoDTO.class);

        return busca.getBody();
    }

}
