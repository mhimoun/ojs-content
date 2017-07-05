package com.ojs.service.content.v1.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JournalIssuesListEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200OKResponseOnJournalIssuesEndpoint() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void shouldReturnLinkToSelf() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andDo(print()).
                andExpect(jsonPath("$.links[?(@.rel=='self')].href").value(("http://localhost/v1/journal/1/issues")));
    }

    @Test
    public void shouldReturnLinkToJournal() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andDo(print()).
                andExpect(jsonPath("$.links[?(@.rel=='journal')].href").value(("http://localhost/v1/journal/1")));
    }


    @Test
    public void shouldReturnJournalId() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andDo(print()).
                andExpect(jsonPath("$.journalId").value(1));

        this.mockMvc.perform(get("/v1/journal/2/issues")).andDo(print()).
                andExpect(jsonPath("$.journalId").value(2));
    }

    @Test
    public void shouldReturnIssuesInTheJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andDo(print()).
                andExpect(jsonPath("$.issues", hasSize(2)));
    }




    @Test
    public void shouldReturnIssueId() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andDo(print()).
                andExpect(jsonPath("$.issues[0].issueId").value(1)).
                andExpect(jsonPath("$.issues[1].issueId").value(3));

    }


    @Test
    public void shouldReturnVolumeNumberAndYear() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andDo(print()).
                andExpect(jsonPath("$.issues[0].volume").value(3)).
                andExpect(jsonPath("$.issues[0].year").value(2016)).
                andExpect(jsonPath("$.issues[0].number").value("12"));

    }
    @Test
    public void shouldReturnIsPublished() throws Exception {

        this.mockMvc.perform(get("/v1/journal/1/issues")).andDo(print()).
                andExpect(jsonPath("$.issues[0].published").value("true")).
                andExpect(jsonPath("$.issues[1].published").value("true"));

    }




}
