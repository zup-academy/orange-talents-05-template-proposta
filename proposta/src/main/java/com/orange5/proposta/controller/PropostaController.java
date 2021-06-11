package com.orange5.proposta.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.orange5.proposta.dto.PropostaRequest;
import com.orange5.proposta.entity.Proposta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * PropostaController
 */
@RestController
@RequestMapping("/api/propostas")
public class PropostaController {
    
    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PropostaRequest propostaRequest, UriComponentsBuilder builder) {
        Proposta newProposta = propostaRequest.toModel();
        manager.persist(newProposta);

        URI path = builder.path("/proposta/{id}").build(newProposta.getId());

        return ResponseEntity.created(path).build();
    }
}