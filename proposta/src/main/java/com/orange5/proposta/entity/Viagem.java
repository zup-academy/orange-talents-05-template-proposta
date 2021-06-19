package com.orange5.proposta.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Viagem {

    @Id
    private String id;

    @Column(nullable = false)
    private @NotBlank String destino;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private @NotNull @Future LocalDate dataFinal;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private String userAgent;

    @ManyToOne
    private Card card;

    public Viagem(@NotBlank String destino, @NotNull LocalDate dataFinal, String ip, String userAgent, Card card) {
        this.destino = destino;
        this.dataFinal = dataFinal;
        this.ip = ip;
        this.userAgent = userAgent;
        this.card = card;
    }

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }

}
