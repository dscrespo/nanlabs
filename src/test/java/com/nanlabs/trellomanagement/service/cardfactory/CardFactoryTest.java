package com.nanlabs.trellomanagement.service.cardfactory;

import com.nanlabs.trellomanagement.model.card.Card;
import com.nanlabs.trellomanagement.model.card.CardBug;
import com.nanlabs.trellomanagement.model.card.CardIssue;
import com.nanlabs.trellomanagement.model.card.CardTask;
import com.nanlabs.trellomanagement.model.mappers.Mappers;
import com.nanlabs.trellomanagement.model.mappers.MappersImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CardFactoryTest {

    @InjectMocks
    private CardFactory cardFactory;

    @Spy
    Mappers mappers = new MappersImpl();

    @BeforeAll
    public void beforeClass() {
        openMocks(this);
    }

    @Test
    public void when_typeIsABug_then_BugCardIsCreated(){
        Card card = cardFactory.getCard(buildCardByType("bug"));
        assertNotNull(card);
        assertEquals(card.getClass(), CardBug.class);
    }

    @Test
    public void when_typeIsAnIssue_then_IssueCardIsCreated(){
        Card card = cardFactory.getCard(buildCardByType("issue"));
        assertNotNull(card);
        assertEquals(card.getClass(), CardIssue.class);
    }

    @Test
    public void when_typeIsATask_then_TaskCardIsCreated(){
        Card card = cardFactory.getCard(buildCardByType("task"));
        assertNotNull(card);
        assertEquals(card.getClass(), CardTask.class);
    }

    @Test
    public void when_parametersAreNotComplete_then_throwsException(){

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->cardFactory.getCard(buildIssueWithMissingParameter()) );

        assertEquals("no se puede crear un Issue", exception.getMessage());
    }

    private Map buildIssueWithMissingParameter() {
        Map<String, String> cardWithoutParameter = buildCardByType("issue");
        cardWithoutParameter.remove("description");
        return cardWithoutParameter;
    }


    private Map buildCardByType(String type){
        Map<String, String> request = new LinkedHashMap<>();
        request.put("type", type);

        if(type.equals("bug")){
            request.put("description", "un bug");
        }
        if(type.equals("task")){
            request.put("title", "una tarea");
            request.put("category", "TEST");
        }
        if(type.equals("issue")){
            request.put("title", "un issue");
            request.put("description", "algun issue sin asignar");
        }
        return request;
    }
}
