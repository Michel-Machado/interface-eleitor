package com.grupo04pj01.urna.interfaceeleitor.controllers;


import com.grupo04pj01.urna.interfaceeleitor.DTO.EnvioVotoDTO;
import com.grupo04pj01.urna.interfaceeleitor.DTO.ResponseLiberacaoUrnaDTO;
import com.grupo04pj01.urna.interfaceeleitor.services.VotarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votar")
@RequiredArgsConstructor
public class VotarController {

    private final VotarService votarService;


    @GetMapping()
    public Boolean isUrnaLiberada(){
        Boolean response= votarService.verificarStatusUrna();
        if (!response) throw new RuntimeException("Eleitor não liberado");
        return true;
    }



    @PostMapping
    public ResponseEntity<Void> enviarVoto(@RequestBody EnvioVotoDTO envioVotoDTO){
        isUrnaLiberada();
        votarService.enviarVoto(envioVotoDTO);

        return ResponseEntity.ok().build();
    }
}

