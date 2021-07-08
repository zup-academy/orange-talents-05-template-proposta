package com.orange5.proposta.dto;

import java.math.BigDecimal;

import com.orange5.proposta.entity.Card;
import com.orange5.proposta.entity.Proposta;
import com.orange5.proposta.enums.PropostaStatus;

public class PropostaResponse {

    private Long id;
    private String codigoPessoa;
    private String email;
    private String nome;
    private String endereco;
    private BigDecimal salario;
    private PropostaStatus status;
    private Card card;

    public PropostaResponse(Proposta proposta) {
        this.id = proposta.getId();
        this.codigoPessoa = proposta.getCodigoPessoa();
        this.email = proposta.getEmail();
        this.nome = proposta.getNome();
        this.endereco = proposta.getEndereco();
        this.salario = proposta.getSalario();
        this.status = proposta.getStatus();
        this.card = proposta.getCard();
    }

    public Long getId() {
        return this.id;
    }

    public String getCodigoPessoa() {
        return this.codigoPessoa;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public PropostaStatus getStatus() {
        return this.status;
    }

    public Card getCard() {
        return this.card;
    }
    

}
