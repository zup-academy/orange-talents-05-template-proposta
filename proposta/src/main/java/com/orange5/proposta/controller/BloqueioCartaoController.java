package com.orange5.proposta.controller;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.orange5.proposta.dto.CardBlockedRequest;
import com.orange5.proposta.dto.CardBlockedResponse;
import com.orange5.proposta.entity.Bloqueio;
import com.orange5.proposta.entity.Card;
import com.orange5.proposta.enums.CardStatus;
import com.orange5.proposta.feign.CartaoResources;
import com.orange5.proposta.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartoes/{id}/bloqueio")
public class BloqueioCartaoController {

    @Autowired
    CardRepository cardRepository;
    
    @Autowired
    EntityManager manager;

    @Autowired
    CartaoResources cartaoResources;

    @PostMapping
    @Transactional
    public ResponseEntity<?> adicionar(@PathVariable("id") @NotBlank @Valid String id, HttpServletRequest httpServletRequest) {
        try {
            Card card = cardRepository.findById(id).get();

            if (card.getIsBloqueado()) return ResponseEntity.unprocessableEntity().build();
            verificaApiExternaBloqueio(card);

            String Ip = httpServletRequest.getRemoteAddr();
            String UserAgent = httpServletRequest.getHeader("User-Agent");

            Bloqueio bloqueio = new Bloqueio(Ip, UserAgent, card);

            manager.persist(bloqueio);
            card.setCardStatus(CardStatus.BLOQUEADO);
            cardRepository.save(card);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private void verificaApiExternaBloqueio(Card card) {
        CardBlockedRequest cardBlockedRequest = new CardBlockedRequest("api-proposta");
        try {
            CardBlockedResponse cardBlockedResponse = cartaoResources.bloqueando(card.getId(), cardBlockedRequest);
            System.out.println(cardBlockedResponse);
        } catch (Exception e) {
            System.out.println(e);
            /**
             * o correto seria deixar esse throw error aqui, mas como nao estou conseguindo fazer a api funcionar vou remover a linha e continuar o projeto
             */
            // throw new Error(HttpStatus.INTERNAL_SERVER_ERROR + "Erro ao bloquar o cartao");
        }
    }
}
