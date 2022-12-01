package com.nanlabs.trellomanagement.client;

import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.card.Card;
import com.nanlabs.trellomanagement.model.card.CardTrelloBoardListId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "trello",
        url = "${trello.api.url}")
public interface TrelloClient {

    @PostMapping(path = "/card/")
    Card insertCard(@RequestBody final Card card,
                    final @RequestParam String idList,
                    final @RequestParam String key,
                    final@RequestParam String token );

    @PostMapping(path = "/card/{idCard}/labels")
    void createLabelOnCard(final @PathVariable String idCard,
                           final @RequestParam String color,
                           final @RequestParam String name,
                           final @RequestParam String key,
                           final@RequestParam String token);


    @GetMapping(path = "/boards/{boardId}/lists")
    List<CardTrelloBoardListId> getIdsBoards(final @PathVariable String boardId,
                                             final @RequestParam String key,
                                             final@RequestParam String token);
}
