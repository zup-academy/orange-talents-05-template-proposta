package com.orange5.proposta.repository;

import com.orange5.proposta.entity.Card;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    
}
