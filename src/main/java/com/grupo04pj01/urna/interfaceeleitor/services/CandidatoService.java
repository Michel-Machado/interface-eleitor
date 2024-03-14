package com.grupo04pj01.urna.interfaceeleitor.services;

import com.grupo04pj01.urna.interfaceeleitor.DTO.BuscaCandidatoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.CandidatoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.EnvioVotoDTO;
import org.springframework.stereotype.Service;

@Service
public interface CandidatoService {
    Boolean verificarStatusUrna();

    CandidatoDTO findCandidato(BuscaCandidatoDTO buscaCandidatoDTO);
}
