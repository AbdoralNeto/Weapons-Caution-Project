package com.cautela.armamento.dto;

import com.cautela.armamento.models.Cautela;
import com.cautela.armamento.models.ModelArma;
import com.cautela.armamento.models.StatusCautela;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class CautelaDto {
    

    private String nomePolicial;
    private String areaAtuacao;
   // private Date dataCautela;
    //private Date dataDevCautela;
    private ModelArma modelArma;
    private StatusCautela statusCautela;
    private Integer quantidadeMunicao;


    public Cautela toCautela(){
        Cautela cautela = new Cautela();
        cautela.setNomePolicial(this.nomePolicial);
        cautela.setAreaAtuacao(this.areaAtuacao);
        //cautela.setDataCautela(this.dataCautela);
        //cautela.setDataDevCautela(this.dataDevCautela);
        cautela.setModelArma(this.modelArma);
        cautela.setStatusCautela(this.statusCautela);
        cautela.setQuantidadeMunicao(this.quantidadeMunicao);
    
        return cautela;
    }

    public void fromCautela(Cautela cautela){
        this.nomePolicial = cautela.getNomePolicial();
        this.areaAtuacao = cautela.getAreaAtuacao();
        this.modelArma = cautela.getModelArma();
        this.statusCautela = cautela.getStatusCautela();
        this.quantidadeMunicao = cautela.getQuantidadeMunicao();
    }


}