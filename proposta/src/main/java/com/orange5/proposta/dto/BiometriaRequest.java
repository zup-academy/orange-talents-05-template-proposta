package com.orange5.proposta.dto;

import javax.validation.constraints.NotBlank;

import com.orange5.proposta.entity.Biometria;
import com.orange5.proposta.entity.Card;
import com.orange5.proposta.validator.Base64;

public class BiometriaRequest {

    @NotBlank
    @Base64(message = "A imagem precisa estar em formato base64")
    private String imagemBase64;

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public Biometria toModel(Card card) {
        return new Biometria(imagemBase64, card);
    }

}
