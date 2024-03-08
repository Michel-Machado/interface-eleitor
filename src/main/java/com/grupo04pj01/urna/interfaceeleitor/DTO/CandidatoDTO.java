package com.grupo04pj01.urna.interfaceeleitor.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidatoDTO {

    public Long id;
    public String foto;
    public String nome;

}
