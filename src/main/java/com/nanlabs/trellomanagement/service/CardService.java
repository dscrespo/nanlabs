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
        String idList = getIdListFromType(request.type);
        client.insertCard(request, idList, key, token);
    }

    private String getIdListFromType(String type){
        // Por ahora no se me ocurrio nada mejor que preguntar por el tipo
        // y asignarle un idList
        String idList ="";
        if(type.toLowerCase().equals("issue")){
            idList = getBoardsIds().stream().filter(x -> x.getName().equals("To Do")).findFirst().get().getId();
        }
        if(type.toLowerCase().equals("bug")){
            idList = getBoardsIds().stream().filter(x -> x.getName().equals("Bug")).findFirst().get().getId();
        }
        if(type.toLowerCase().equals("task")){
            idList = getBoardsIds().stream().filter(x -> x.getName().equals("Task")).findFirst().get().getId();
        }
        return idList;
    }
    private List<CardList> getBoardsIds(){
        List<CardList> idList = client.getIdsBoards(boardId, key, token);
        return  idList;
    }

}
