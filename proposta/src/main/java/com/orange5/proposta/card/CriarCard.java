package com.orange5.proposta.card;

import com.orange5.proposta.entity.Card;
import com.orange5.proposta.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarCard {

    @Autowired
    CardRepository cardRepository;

    public Card newCard(CardResponse cardResponse) {
        Card card = cardResponse.toModel();
        cardRepository.save(card);

        return card;
    }

}
