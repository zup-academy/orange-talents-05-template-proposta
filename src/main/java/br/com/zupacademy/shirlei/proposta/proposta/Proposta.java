package br.com.zupacademy.shirlei.proposta.proposta;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    @NotNull
    @NotEmpty
    private String documento;

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String endereco;

    @NotNull
    @Positive
    private BigDecimal salario;


    public Proposta(@CPF @NotNull @NotEmpty String documento, @Email @NotNull @NotEmpty String email,
                    @NotNull @NotEmpty String nome, @NotNull @NotEmpty String endereco,
                    @NotNull @Positive BigDecimal salario){
                        this.documento = documento;
                        this.email = email;
                        this.nome = nome;
                        this.endereco = endereco;
                        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
