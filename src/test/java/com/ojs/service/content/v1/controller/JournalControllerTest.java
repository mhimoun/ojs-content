package com.ojs.service.content.v1.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class JournalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200OKResponseOnDefaultJournalEndpoint() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void shouldReturnLinkToSelf() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.links[?(@.rel=='self')].href").value(("http://localhost/v1/journal")));
    }

    @Test
    public void shouldReturnUpdated() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).
                andExpect(jsonPath("$.updated").isNotEmpty());
    }

    @Test
    public void shouldReturnJournalsInTheJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals", hasSize(2)));
    }

    @Test
    public void shouldReturnJournalId() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).
                andExpect(jsonPath("$.journals[0].journalId").value(1)).
                andExpect(jsonPath("$.journals[1].journalId").value(2));
    }


    @Test
    public void shouldReturnJournalPath() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals[0].path").value("path-context")).
                andExpect(jsonPath("$.journals[1].path").value("path-context-2"));
    }


    @Test
    public void shouldReturnJournalDescription() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals[0].description").value("<p>the journal description</p>")).
                andExpect(jsonPath("$.journals[1].description").value("<p>the journal description 2</p>"));
    }

    @Test
    public void shouldReturnJournalOnlineIssn() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals[0].onlineIssn").value("1365-2435"));
    }


}
