package com.nanlabs.trellomanagement.service.cardfactory;

import com.nanlabs.trellomanagement.model.TO.BugTO;
import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.TO.IssueTO;
import com.nanlabs.trellomanagement.model.TO.TaskTO;
import com.nanlabs.trellomanagement.model.card.Card;
import com.nanlabs.trellomanagement.model.card.CardBug;
import com.nanlabs.trellomanagement.model.card.CardIssue;
import com.nanlabs.trellomanagement.model.card.CardTask;
import com.nanlabs.trellomanagement.model.mappers.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class CardFactory<T> implements  ICardFactory<T>{

    @Autowired
    private Mappers mappers;

    @Override
    public Card getCard(T card) {
        LinkedHashMap request = (LinkedHashMap) card;
        switch (request.get("type").toString().toLowerCase()) {
            case "issue":
                IssueTO issueTO = new IssueTO(request);
                CardIssue issue = mappers.IssueTOToCardIssue(issueTO);
                return issue;
            case "bug":
                BugTO bugTO =  new BugTO(request);
                CardBug bug = mappers.BugTOToCardBug(bugTO);
                return bug;
            case "task":
                TaskTO taskTO =  new TaskTO(request);
                CardTask task = mappers.TaskTOToCardTask(taskTO);
                return task;
            default:
                throw new UnsupportedOperationException("no existe el type: " + request.get("type").toString().toLowerCase());
        }
    }


}
