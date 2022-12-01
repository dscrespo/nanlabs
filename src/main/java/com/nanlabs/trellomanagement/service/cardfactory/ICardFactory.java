package com.nanlabs.trellomanagement.service.cardfactory;

import com.nanlabs.trellomanagement.model.card.Card;

public interface ICardFactory<T> {

    Card getCard(T card);
}
