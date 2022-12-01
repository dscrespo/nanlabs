package com.nanlabs.trellomanagement.model.mappers;

import com.nanlabs.trellomanagement.model.TO.BugTO;
import com.nanlabs.trellomanagement.model.TO.IssueTO;
import com.nanlabs.trellomanagement.model.TO.TaskTO;
import com.nanlabs.trellomanagement.model.card.CardBug;
import com.nanlabs.trellomanagement.model.card.CardIssue;
import com.nanlabs.trellomanagement.model.card.CardTask;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface Mappers {

    @Mapping(target="name", source="title")
    @Mapping(target="desc", source="description")
    CardBug BugTOToCardBug(BugTO bugTO);
    @Mapping(target="name", source="title")
    @Mapping(target="desc", source="description")
    CardIssue IssueTOToCardIssue(IssueTO issueTO);
    @Mapping(target="name", source="title")
    CardTask TaskTOToCardTask(TaskTO taskTO);

}
