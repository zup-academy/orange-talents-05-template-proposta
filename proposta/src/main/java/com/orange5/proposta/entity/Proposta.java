package com.orange5.proposta.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.orange5.proposta.validator.CPForCNPJ;

@Entity
public class Proposta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private @NotBlank @CPForCNPJ String codigoPessoa;

    @Column(nullable = false)
    private @NotBlank @Email String email;

    @Column(nullable = false)
    private @NotBlank String nome;

    @Column(nullable = false)
    private @NotBlank String endereco;

    @Column(nullable = false)
    private @Positive @NotNull BigDecimal salario;

    public Proposta(@NotBlank String codigoPessoa, @NotBlank @Email String email, @NotBlank String nome,
            @NotBlank String endereco, @Positive @NotNull BigDecimal salario) {
        this.codigoPessoa = codigoPessoa;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    @Deprecated
    public Proposta() {
    }

    public Long getId() {
        return this.id;
    }


}
