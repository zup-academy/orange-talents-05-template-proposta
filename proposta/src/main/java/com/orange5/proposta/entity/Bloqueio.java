package com.orange5.proposta.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Bloqueio {

    @Id
    private String id;

    @Column(nullable = false)
    private String clientIp;

    @Column(nullable = false)
    private String userAgent;
    
    @ManyToOne
    private Card card;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Bloqueio(String Ip, String UserAgent, Card card) {
        this.clientIp = Ip;
        this.userAgent = UserAgent;
        this.card = card;
    }

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
    }

}
