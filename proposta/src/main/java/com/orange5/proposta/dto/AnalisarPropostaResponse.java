package com.orange5.proposta.dto;

public class AnalisarPropostaResponse {
    
    private String documento;
    private String nome;
    private String resultadoSolicitacao;
    private String idProposta;

    public AnalisarPropostaResponse(String documento, String nome, String resultadoSolicitacao, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return this.documento;
    }

    public String getNome() {
        return this.nome;
    }

    public String getResultadoSolicitacao() {
        return this.resultadoSolicitacao;
    }

    public String getIdProposta() {
        return this.idProposta;
    }

}
