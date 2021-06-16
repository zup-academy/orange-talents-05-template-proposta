package com.orange5.proposta.repository;

import java.util.Optional;

import com.orange5.proposta.entity.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long> {
    
    @Query("Select c From Card c where id =:id")
    Optional<Card> findByStringId(String id);
}
