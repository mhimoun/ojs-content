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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200OKResponseOnDefaultArticleEndpoint() throws Exception {

        this.mockMvc.perform(get("/v1/article/1")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/article/1")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }


    @Test
    public void shouldReturnLinkToSelf() throws Exception {

        this.mockMvc.perform(get("/v1/article/1")).
                andExpect(jsonPath("$.links[?(@.rel=='self')].href").value(("http://localhost/v1/article/1")));
    }


    @Test
    public void shouldReturnLinkToJournal() throws Exception {

        this.mockMvc.perform(get("/v1/article/1")).
                andExpect(jsonPath("$.links[?(@.rel=='journal')].href").value(("http://localhost/v1/journal/1")));
    }


    @Test
    public void shouldReturnLinkToIssue() throws Exception {

        this.mockMvc.perform(get("/v1/article/1")).
                andExpect(jsonPath("$.links[?(@.rel=='issue')].href").value(("http://localhost/v1/issue/10")));
    }


    @Test
    public void shouldReturnJournalId() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.journalId").value(1));
    }


    @Test
    public void shouldReturnIssueId() throws Exception {

        this.mockMvc.perform(get("/v1/article/1")).
                andExpect(jsonPath("$.issueId").value(10));
    }


    @Test
    public void shouldReturnArticleId() throws Exception {

        this.mockMvc.perform(get("/v1/article/5")).
                andExpect(jsonPath("$.articleId").value(5));
    }


}