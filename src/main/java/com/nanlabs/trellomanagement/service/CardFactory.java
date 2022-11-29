package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.model.TO.BugTO;
import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.TO.IssueTO;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class CardFactory<T> {


    public CardTO getCard(T card) {
        LinkedHashMap request = (LinkedHashMap) card;
        switch (request.get("type").toString()) {
            case "issue":
                return new IssueTO(request);
            case "bug":
                return new BugTO(request);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
