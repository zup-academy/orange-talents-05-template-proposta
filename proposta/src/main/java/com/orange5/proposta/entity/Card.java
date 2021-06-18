package com.orange5.proposta.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.orange5.proposta.enums.CardStatus;

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

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus = CardStatus.SEM_BLOQUEIO;

    public Card(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite) {
        this.id = id;
        this.emissao = emitidoEm;
        this.titular = titular;
        this.limite = limite;
    }

    @Deprecated
    public Card() {
    }

    public String getId() {
        return this.id;
    }

    public LocalDateTime getEmissao() {
        return this.emissao;
    }

    public String getTitular() {
        return this.titular;
    }

    public BigDecimal getLimite() {
        return this.limite;
    }

    public CardStatus getCardStatus() {
        return this.cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public boolean getIsBloqueado() {
        return this.cardStatus.equals(CardStatus.BLOQUEADO);
    }

}
