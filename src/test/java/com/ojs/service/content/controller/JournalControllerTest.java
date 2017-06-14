package com.ojs.service.content.controller;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class JournalControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    JournalController journalController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(journalController).build();
    }

    @Test
    public void shouldReturn200OKResponseOnDefaultJournalEndpoint() throws Exception {

        this.mockMvc.perform(get("/journal")).andExpect(status().isOk());
    }
}
