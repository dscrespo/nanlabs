package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.client.TrelloClient;
import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.card.CardList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService<T> {

    @Value(("${trello.api.key.public}"))
    private String key;

    @Value(("${trello.api.key.token}"))
    private String token;

    @Value(("${trello.board.id}"))
    private String boardId;

    @Autowired
    CardFactory cardFactory;

    @Autowired
    TrelloClient client;

    public void insertCard(T card) {
        CardTO request = cardFactory.getCard(card);
        client.insertCard(request, getBoardsIds().get(0).getId(), key, token);
    }

    public List<CardList> getBoardsIds(){
        List<CardList> idList = client.getIdsBoards(boardId, key, token);
        return  idList;
    }
}
