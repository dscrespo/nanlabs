package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.model.card.Bug;
import com.nanlabs.trellomanagement.model.card.Card;
import com.nanlabs.trellomanagement.model.card.Issue;
import com.nanlabs.trellomanagement.model.card.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class CardFactory<T> {


    public Card getCard(T card) {
        LinkedHashMap request = (LinkedHashMap) card;
        switch (request.get("type").toString()) {
            case "issue":
                return new Issue(request);
            case "bug":
                return new Bug(request);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
