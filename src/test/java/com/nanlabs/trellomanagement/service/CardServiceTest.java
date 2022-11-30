package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.client.TrelloClient;
import com.nanlabs.trellomanagement.service.cardfactory.CardFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardServiceTest {

    @InjectMocks
    private CardService service;

    @InjectMocks
    CardFactory cardFactory;

    @Mock
    private TrelloClient trelloClient;


    @Test
    public void when_insertABugCard__then_invokesInsertCard() {

    }

    @Test
    public void when_insertATaskCard__then_invokesInsertCardAndCreateLabelOnCard() {

    }


}
