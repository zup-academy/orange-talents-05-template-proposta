package br.com.zupacademy.shirlei.proposta.proposta;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaDTO {


        @CPF @NotNull
        @NotEmpty
        private String documento;

        @Email @NotNull
        @NotEmpty
        private String email;

        @NotNull @NotEmpty
        private String nome;

        @NotNull @NotEmpty
        private String endereco;

        @NotNull @Positive
        private BigDecimal salario;

        public PropostaDTO(@CPF @NotNull @NotEmpty String documento, @Email @NotNull @NotEmpty String email,
                @NotNull @NotEmpty String nome, @NotNull @NotEmpty String endereco,
                @NotNull @Positive BigDecimal salario) {
            super();
            this.documento = documento;
            this.email = email;
            this.nome = nome;
            this.endereco = endereco;
            this.salario = salario;
        }

    public PropostaDTO(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.email = proposta.getEmail();
        this.nome = proposta.getNome();
        this.endereco = proposta.getEndereco();
        this.salario = proposta.getSalario();
    }

    public Proposta toModel() {
        return new Proposta(documento,email,nome,endereco,salario);
    }


    public Proposta converter() {
            return new Proposta(this.documento, this.email, this.nome, this.endereco, this.salario);
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

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public void setSalario(BigDecimal salario) {
            this.salario = salario;
        }
  }
