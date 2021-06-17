package com.orange5.proposta.controller;

import javax.persistence.EntityManager;

import com.orange5.proposta.dto.PropostaResponse;
import com.orange5.proposta.entity.Proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/propostas")
public class PropostaDetailController {

    @Autowired
    EntityManager manager;
    
    @GetMapping("/{id}")
    public ResponseEntity<PropostaResponse> buscar(@PathVariable("id") Long id) {
        Proposta proposta = manager.find(Proposta.class, id);

        if (proposta == null ) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new PropostaResponse(proposta));
    }
}
