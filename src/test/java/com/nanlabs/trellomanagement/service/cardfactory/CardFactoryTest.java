package com.nanlabs.trellomanagement.service.cardfactory;

import com.nanlabs.trellomanagement.model.TO.BugTO;
import com.nanlabs.trellomanagement.model.TO.CardTO;
import com.nanlabs.trellomanagement.model.TO.IssueTO;
import com.nanlabs.trellomanagement.model.TO.TaskTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardFactoryTest {

    @InjectMocks
    private CardFactory cardFactory;

    @BeforeAll
    public void beforeClass() {
        openMocks(this);
    }

    @Test
    public void when_typeIsABug_then_BugCardIsCreated(){
        CardTO card = cardFactory.getCard(buildCardByType("bug"));
        assertNotNull(card);
        assertEquals(card.getClass(), BugTO.class);
    }

    @Test
    public void when_typeIsAnIssue_then_IssueCardIsCreated(){
        CardTO card = cardFactory.getCard(buildCardByType("issue"));
        assertNotNull(card);
        assertEquals(card.getClass(), IssueTO.class);
    }

    @Test
    public void when_typeIsATask_then_TaskCardIsCreated(){
        CardTO card = cardFactory.getCard(buildCardByType("task"));
        assertNotNull(card);
        assertEquals(card.getClass(), TaskTO.class);
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
