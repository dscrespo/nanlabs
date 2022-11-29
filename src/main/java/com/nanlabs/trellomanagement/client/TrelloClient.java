package com.nanlabs.trellomanagement.client;

import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.card.CardList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "trello",
        url = "${trello.api.url}")
public interface TrelloClient {

    @PostMapping(path = "/card/")
    void insertCard(CardTO card);

    @GetMapping(path = "/boards/{boardId}/lists")
    List<CardList> getIdsBoards(final @PathVariable String boardId,
                                final @RequestParam String key,
                                final@RequestParam String token);
}
