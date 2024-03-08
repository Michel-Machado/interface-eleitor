package com.grupo04pj01.urna.interfaceeleitor.services;

import com.grupo04pj01.urna.interfaceeleitor.DTO.EnvioVotoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.ResponseLiberacaoUrnaDTO;
import org.springframework.stereotype.Service;

@Service
public interface VotarService {
    Boolean verificarStatusUrna();

    void enviarVoto(EnvioVotoDTO envioVotoDTO);
}
