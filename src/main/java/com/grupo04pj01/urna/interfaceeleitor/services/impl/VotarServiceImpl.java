package com.grupo04pj01.urna.interfaceeleitor.services.impl;

import com.grupo04pj01.urna.interfaceeleitor.DTO.EnvioVotoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.ResponseLiberacaoUrnaDTO;
import com.grupo04pj01.urna.interfaceeleitor.services.VotarService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class VotarServiceImpl implements VotarService {

    private final RestTemplate restTemplate;

    @Override
    public Boolean verificarStatusUrna() {
        ResponseEntity<ResponseLiberacaoUrnaDTO> resposta= restTemplate.getForEntity("http://localhost:8080/liberacao_urna",ResponseLiberacaoUrnaDTO.class);
        ResponseLiberacaoUrnaDTO bodyResposta= resposta.getBody();
        return bodyResposta.getIsUrnaLiberada();
    }

    @Override
    public void enviarVoto(EnvioVotoDTO envioVotoDTO) {
        verificarStatusUrna();

        JSONObject body= new JSONObject();
        body.put("chapa", envioVotoDTO.getChapa());

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(body.toString(),httpHeaders);

        ResponseEntity<String> envio= restTemplate.postForEntity("http://localhost:8080/voto", requestEntity, String.class);
    }
}
