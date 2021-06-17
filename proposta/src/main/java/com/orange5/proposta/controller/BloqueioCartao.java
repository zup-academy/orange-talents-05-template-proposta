package com.orange5.proposta.controller;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.orange5.proposta.entity.Bloqueio;
import com.orange5.proposta.entity.Card;
import com.orange5.proposta.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartoes/{id}/bloqueio")
public class BloqueioCartao {

    @Autowired
    CardRepository cardRepository;
    
    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> adicionar(@PathVariable("id") @NotBlank @Valid String id, HttpServletRequest httpServletRequest) {
        try {
            Card card = cardRepository.findById(id).get();

            if (card.getIsBloqueado()) return ResponseEntity.unprocessableEntity().build();

            String Ip = httpServletRequest.getRemoteAddr();
            String UserAgent = httpServletRequest.getHeader("User-Agent");

            Bloqueio bloqueio = new Bloqueio(Ip, UserAgent, card);

            manager.persist(bloqueio);
            card.setIsBloqueado(true);
            cardRepository.save(card);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
