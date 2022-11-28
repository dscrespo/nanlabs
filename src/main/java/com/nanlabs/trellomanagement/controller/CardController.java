package com.nanlabs.trellomanagement.controller;

import com.nanlabs.trellomanagement.model.card.Card;
import com.nanlabs.trellomanagement.service.CardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping(value = "api/card", produces = APPLICATION_JSON_VALUE)
public class CardController<T> {

    @Autowired
    CardService cardService;

    @GetMapping("/test")
    public ResponseEntity testApi(){
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/insertcard")
    public ResponseEntity insertCard(@RequestBody T card){
        cardService.insertCard(card);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
