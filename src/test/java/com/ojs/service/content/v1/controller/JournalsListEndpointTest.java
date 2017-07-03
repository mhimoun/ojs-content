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
public class JournalsListEndpointTest {

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
                andExpect(jsonPath("$.journals[0].searchDescription").value("brief description of the journal which search engines can display when listing the journal in search results.")).
                andExpect(jsonPath("$.journals[1].searchDescription").value("brief description."));
    }


    @Test
    public void shouldReturnJournalAbbreviation() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals[0].abbreviation").value("Journal Abbreviation"));
    }



    @Test
    public void shouldReturnJournalName() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals[0].name").value("Test default name"));
    }




    @Test
    public void shouldReturnJournalShortDescription() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals[0].searchDescription").value("brief description of the journal which search engines can display when listing the journal in search results."));
    }




    @Test
    public void shouldNotIncludeJournalDetailsInListing() throws Exception {

        this.mockMvc.perform(get("/v1/journal")).andDo(print()).
                andExpect(jsonPath("$.journals[0].description").doesNotExist()).
                andExpect(jsonPath("$.journals[0].printIssn").doesNotExist()).
                andExpect(jsonPath("$.journals[0].printIssn").doesNotExist()).
                andExpect(jsonPath("$.journals[0].contactName").doesNotExist());
    }



}
