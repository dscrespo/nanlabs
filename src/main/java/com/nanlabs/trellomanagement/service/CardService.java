package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.client.TrelloClient;
import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.TO.Labels;
import com.nanlabs.trellomanagement.model.TO.TaskTO;
import com.nanlabs.trellomanagement.model.card.Card;
import com.nanlabs.trellomanagement.model.card.CardTask;
import com.nanlabs.trellomanagement.model.card.CardTrelloBoardListId;
import com.nanlabs.trellomanagement.service.cardfactory.ICardFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class CardService<T> {

    @Value(("${trello.api.key.public}"))
    private String key;

    @Value(("${trello.api.key.token}"))
    private String token;

    @Value(("${trello.board.id}"))
    private String boardId;

    @Autowired
    ICardFactory cardFactory;

    @Autowired
    TrelloClient client;

    private
    Map<String, String> boardColumns;

    public void insertCard(T card) {
        Card request = cardFactory.getCard(card);
        String idList = getIdListFromType(request.getType());
        Card cardResponse = client.insertCard(request, idList, key, token);
        if(request instanceof CardTask){
            client.createLabelOnCard(cardResponse.getId(), Labels.valueOf(((CardTask) request).getCategory().toUpperCase()).label,
                                     ((CardTask) request).getCategory(), key, token);
        }
    }

    private String getIdListFromType(String type){
        // mejor, pero no logro zafar de algunos if
        if(type.equals("issue")){
            type = "to do";
        }
        if(getBoardsIds().containsKey(type)) {
            return getBoardsIds().get(type);
        } else{
            throw new IllegalArgumentException();
        }
    }
    private Map<String, String> getBoardsIds(){
        List<CardTrelloBoardListId> idList = client.getIdsBoards(boardId, key, token);
        boardColumns = new TreeMap<>();
        for(CardTrelloBoardListId card: idList){
            boardColumns.put(card.getName().toLowerCase(), card.getId());
        }
        return  boardColumns;
    }

}
