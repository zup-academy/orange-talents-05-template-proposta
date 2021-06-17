package com.orange5.proposta.controller;

import java.net.URI;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.orange5.proposta.dto.BiometriaRequest;
import com.orange5.proposta.entity.Biometria;
import com.orange5.proposta.entity.Card;
import com.orange5.proposta.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/biometrias")
public class BiometriaController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    EntityManager manager;

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<?> cadastrar(@PathVariable("id") String id, @RequestBody @Valid BiometriaRequest biometriaRequest,
            UriComponentsBuilder uriComponentsBuilder) {
        
        try {
            Optional<Card> card = cardRepository.findById(id);

            Biometria biometria = biometriaRequest.toModel(card.get());
            manager.persist(biometria);

            URI path = uriComponentsBuilder.path("/api/biometrias/{id}").buildAndExpand(biometria.getId()).toUri();

            return ResponseEntity.created(path).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
