package com.orange5.proposta.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Biometria {

    @Id
    private String id;

    @NotBlank
    @Column(nullable = false)
    private @NotBlank String imagens;

    @NotNull
    @ManyToOne
    private Card card;

    public Biometria(@NotBlank @NotBlank String imagemBase64, Card card) {
        this.imagens = imagemBase64;
        this.card = card;
    }

    public Biometria() {
    }

    public String getId() {
        return id;
    }

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
}
