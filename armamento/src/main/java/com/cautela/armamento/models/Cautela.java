package com.cautela.armamento.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cautela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomePolicial;

    @NotNull
    private String areaAtuacao;

    //@DateTimeFormat(pattern = "yyyyMMdd")
    //private Date dataCautela;
    
    //@DateTimeFormat(pattern = "yyyyMMdd")
    //private Date dataDevCautela;

    
    @Enumerated(EnumType.STRING)
    private ModelArma modelArma;

    @Enumerated(EnumType.STRING)
    private StatusCautela statusCautela;


    private Integer quantidadeMunicao;



}