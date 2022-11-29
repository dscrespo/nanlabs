package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.client.TrelloClient;
import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.card.CardList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService<T> {

    @Autowired
    CardFactory cardFactory;

    @Autowired
    TrelloClient client;

    public void insertCard(T card) {
        getBoardsIds();
        CardTO request = cardFactory.getCard(card);
        System.out.println(request);
    }

    public void getBoardsIds(){
        List<CardList> idList = client.getIdsBoards("4f8082379869adc2345e251249b5809d", "dcd0cc8704ab7e35a308ed9617d461145d1edf79a45b3d4392f22f80670ff241");
        System.out.println(idList);
    }
}
