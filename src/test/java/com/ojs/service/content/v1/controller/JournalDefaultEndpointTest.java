package com.ojs.service.content.v1.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JournalDefaultEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200OKResponseOnDefaultJournalEndpoint() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void shouldReturnLinkToSelf() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1")).andDo(print()).
                andExpect(jsonPath("$.links[?(@.rel=='self')].href").value(("http://localhost/v1/journal/1")));
    }


    @Test
    public void shouldReturnJournalId() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1")).andDo(print()).
                andExpect(jsonPath("$.journalId").value(1));

     this.mockMvc.perform(get("/v1/journal/2")).andDo(print()).
                andExpect(jsonPath("$.journalId").value(2));
    }


    @Test
    public void shouldReturnJournalPath() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1")).andDo(print()).
                andExpect(jsonPath("$.path").value("path-context"));
    }


    @Test
    public void shouldReturnJournalMainFields() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1")).andDo(print()).
                andExpect(jsonPath("$.description").value("<p>the journal description</p>")).
                andExpect(jsonPath("$.searchDescription").value("brief description of the journal which search engines can display when listing the journal in search results.")).
                andExpect(jsonPath("$.abbreviation").value("Journal Abbreviation")).
                andExpect(jsonPath("$.name").value("Test default name")).
                andExpect(jsonPath("$.onlineIssn").value("1365-2435")).
                andExpect(jsonPath("$.printIssn").value("1365-2425"));
    }

    @Test
    public void shouldReturnJournalContactInfo() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1")).andDo(print()).
                andExpect(jsonPath("$.contactEmail").value("journal-contact@yahoo.fr")).
                andExpect(jsonPath("$.contactName").value("dupon jard")).
                andExpect(jsonPath("$.contactPhone").value("0778965404")).
                andExpect(jsonPath("$.contactTitle").value("DR")).
                andExpect(jsonPath("$.contactAffiliation").value("this is affliated to global journal"));
    }

    @Test
    public void shouldReturn404NotFoundResponseWhenJournalDoesNotExist() throws Exception {

        this.mockMvc.perform(get("/v1/journal/404")).andExpect(status().isNotFound());
    }


}
