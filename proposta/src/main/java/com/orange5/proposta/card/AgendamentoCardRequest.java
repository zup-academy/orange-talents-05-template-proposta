package com.orange5.proposta.card;

import java.util.List;

import com.orange5.proposta.entity.Card;
import com.orange5.proposta.entity.Proposta;
import com.orange5.proposta.feign.CartaoResources;
import com.orange5.proposta.repository.PropostaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoCardRequest {

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    CartaoResources cartaoResources;

    @Autowired
    CriarCard criarCard;

    @Scheduled(fixedDelayString = "${periodicidade.executa-operacao}")
    public void executaOperacao() {
        List<Proposta> propostasAprovadas = propostaRepository.findAprovados();

        propostasAprovadas.forEach(proposta -> {
            try {
                CardResponse cardResponse = cartaoResources.getByPropostaId(proposta.getId());
                Card card = criarCard.newCard(cardResponse);
                proposta.setCard(card);
                propostaRepository.save(proposta);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}
