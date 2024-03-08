package com.grupo04pj01.urna.interfaceeleitor.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLiberacaoUrnaDTO {

    private Boolean isUrnaLiberada;


}
