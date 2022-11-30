package com.nanlabs.trellomanagement.service;

import com.nanlabs.trellomanagement.client.TrelloClient;
import com.nanlabs.trellomanagement.service.cardfactory.CardFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardServiceTest {

    @InjectMocks
    private CardService service;

    @InjectMocks
    CardFactory cardFactory;

    @Mock
    private TrelloClient trelloClient;


    @Test
    public void when_triesGetActiveAccountInARSCurrency_but_clientAccountDetailFails_then_throwsException() {

       /* BusinessException exception = assertThrows(BusinessException.class, () ->
                service.getActiveAccountInARSCurrency(DOCUMENT_TYPE_CUIL, DOCUMENT_NUMBER));

        assertEquals("An error occurred while getting client account detail", exception.getMessage());*/
    }


}
