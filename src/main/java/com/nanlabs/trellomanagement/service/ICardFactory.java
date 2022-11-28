package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.model.card.Card;

public interface ICardFactory<T> {

    public Card getCard(T card);
}
