package com.orange5.proposta.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class AnalisarPropostaRequest {

    @JsonProperty
    private String documento;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String idProposta;

    public AnalisarPropostaRequest(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    @Deprecated
    public AnalisarPropostaRequest() {
    }

}
