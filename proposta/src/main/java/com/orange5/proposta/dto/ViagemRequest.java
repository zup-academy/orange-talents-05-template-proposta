package com.orange5.proposta.dto;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.orange5.proposta.entity.Card;
import com.orange5.proposta.entity.Viagem;

public class ViagemRequest {

    @NotBlank
    private String destino;

    @Future
    @NotNull
    private LocalDate dataFinal;

    public ViagemRequest(String destino, String dataFinal) {
        this.destino = destino;
        this.dataFinal = LocalDate.parse(dataFinal);
    }

    public Viagem toModel(Card card, HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getRemoteAddr();
        String userAgent = httpServletRequest.getHeader("User-Agent");

        return new Viagem(this.destino, this.dataFinal, ip, userAgent, card);
    }

}
