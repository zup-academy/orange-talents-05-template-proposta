package com.orange5.proposta.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.orange5.proposta.entity.Proposta;
import com.orange5.proposta.validator.CPForCNPJ;

public class PropostaRequest {

    @NotBlank
    @CPForCNPJ(message = "É preciso adicionar um cpf ou cnpj valido")
    private String codigoPessoa;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @Positive
    @NotNull
    private BigDecimal salario;


    public PropostaRequest(String codigoPessoa, String email, String nome, String endereco, BigDecimal salario) {
        super();
        this.codigoPessoa = codigoPessoa;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Proposta toModel() {
        return new Proposta(this.codigoPessoa, this.email, this.nome, this.endereco, this.salario);
    }

    public String getCodigoPessoa() {
        return this.codigoPessoa;
    }



}
