package com.orange5.proposta.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardBlockedRequest {

    @JsonProperty
    private String sistemaResponsavel;

    public CardBlockedRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }
 
}
