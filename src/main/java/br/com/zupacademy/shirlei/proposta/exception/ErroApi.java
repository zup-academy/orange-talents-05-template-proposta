package br.com.zupacademy.shirlei.proposta.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//essa classe representa o erro de validação. Para que o retorno do erro seja um json mais limpo e organizado. Mas fácil de entender

@JsonInclude(Include.NON_NULL)
public class ErroApi {

    private String campo;
    private String erro;

    public ErroApi(String campo, String erro) { //construtor com o que quero que retorne. campo e erro/mensagem
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {

        return campo;
    }

    public String getErro() {

        return erro;
    }

}
