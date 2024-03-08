package com.grupo04pj01.urna.interfaceeleitor.controllers;


import com.grupo04pj01.urna.interfaceeleitor.DTO.BuscaCandidatoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.CandidatoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.EnvioVotoDTO;
import com.grupo04pj01.urna.interfaceeleitor.services.CandidatoService;
import com.grupo04pj01.urna.interfaceeleitor.services.VotarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidato")
@RequiredArgsConstructor
public class CandidatoController {

    private final VotarService votarService;
    private final CandidatoService candidatoService;


    @GetMapping()
    public Boolean isUrnaLiberada(){
        Boolean response= votarService.verificarStatusUrna();
        if (!response) throw new RuntimeException("Eleitor não liberado");
        return true;
    }



   @PostMapping
    public ResponseEntity<CandidatoDTO> buscaCandidato(@RequestBody BuscaCandidatoDTO buscaCandidatoDTO){
        isUrnaLiberada();

       CandidatoDTO candidatoDTO= candidatoService.findCandidato(buscaCandidatoDTO);

        return ResponseEntity.ok().body(candidatoDTO);
    }
}

