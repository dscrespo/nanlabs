package com.nanlabs.trellomanagement.service.cardfactory;

import com.nanlabs.trellomanagement.model.TO.CardTO;

public interface ICardFactory<T> {

    public CardTO getCard(T card);
}
