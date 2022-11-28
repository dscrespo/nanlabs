package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.model.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService<T> {

    @Autowired
    CardFactory cardFactory;

    public void insertCard(T card) {
        Card request = cardFactory.getCard(card);
        System.out.println(request);
    }
}
