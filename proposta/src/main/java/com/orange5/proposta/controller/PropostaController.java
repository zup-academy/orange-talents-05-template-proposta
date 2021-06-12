package com.orange5.proposta.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.orange5.proposta.dto.AnalisarPropostaResponse;
import com.orange5.proposta.dto.PropostaRequest;
import com.orange5.proposta.entity.Proposta;
import com.orange5.proposta.enums.PropostaStatus;
import com.orange5.proposta.feign.AnalisarProposta;
import com.orange5.proposta.repository.PropostaRepository;
import com.orange5.proposta.utils.StatusMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    AnalisarProposta analiseProposta;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PropostaRequest propostaRequest,
            UriComponentsBuilder builder) {
        Optional<Proposta> existCodigoPessoa = propostaRepository.findByCodigoPessoa(propostaRequest.getCodigoPessoa());

        if (existCodigoPessoa.isPresent())
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        Proposta newProposta = propostaRequest.toModel();
        propostaRepository.save(newProposta);

        analisarProposta(newProposta);

        URI path = builder.path("/proposta/{id}").build(newProposta.getId());

        return ResponseEntity.created(path).build();
    }

    private void analisarProposta(Proposta proposta) {
        AnalisarPropostaRequest analisarPropostaRequest = new AnalisarPropostaRequest(
            proposta.getCodigoPessoa(),
            proposta.getNome(),
            proposta.getId().toString()
        );
        try {
            AnalisarPropostaResponse analisePropostaResponse = analiseProposta.analisarRequest(analisarPropostaRequest);
            proposta.setStatus(StatusMapper.statusMap.get(analisePropostaResponse.getResultadoSolicitacao()));
            propostaRepository.save(proposta);
        } catch (Exception e) {
            proposta.setStatus(PropostaStatus.NAO_ELEGIVEL);
        }
        
    }
}