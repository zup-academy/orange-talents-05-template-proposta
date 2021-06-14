package com.orange5.proposta.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Card {

    @Id
    private String id;
    
    @Column(nullable = false)
    private LocalDateTime emissao;

    @NotNull
    @Column(nullable = false)
    private String titular;
    
    @NotNull
    @Column(nullable = false)
    private BigDecimal limite;

    public Card(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite) {
        this.id = id;
        this.emissao = emitidoEm;
        this.titular = titular;
        this.limite = limite;
    }

    @Deprecated
    public Card() {
    }


}
