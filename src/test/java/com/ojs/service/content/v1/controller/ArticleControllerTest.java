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

        this.mockMvc.perform(get("/v1/article/2")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }


    @Test
    public void shouldReturnLinkToSelf() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.links[?(@.rel=='self')].href").value(("http://localhost/v1/article/2")));
    }

    @Test
    public void shouldReturnLinkToIssue() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.links[?(@.rel=='issue')].href").value(("http://localhost/v1/issue/1")));
    }

    @Test
    public void shouldReturnIssueId() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.issueId").value(1));
    }


    @Test
    public void shouldReturnArticleId() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.articleId").value(2));
    }

    @Test
    public void shouldReturn404NotFoundIfArticleDoesNotExist() throws Exception {

        this.mockMvc.perform(get("/v1/article/404")).andExpect(status().isNotFound());

    }

    @Test
    public void shouldRetrun404NotFoundIfArticleIsNotPublished() throws Exception {

        this.mockMvc.perform(get("/v1/article/1")).andExpect(status().isNotFound());

    }

    @Test
    public void shouldReturnDatePublished() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.datePublished").value("29-06-2017 00:00:00"));
    }

    @Test
    public void shouldReturnArticlePages() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.pages").value("45"));

    }

    @Test
    public void shouldReturnArticleTitles() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.title").value("article title")).
                andExpect(jsonPath("$.cleanTitle").value("article title")).
                andExpect(jsonPath("$.subTitle").value("some sub tilte"));

    }

    @Test
    public void shouldReturnArticleCopyrightInfo() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.copyrightYear").value("2017")).
                andExpect(jsonPath("$.copyrightHolder").value("Test default 1"));
    }

    @Test
    public void shouldReturnArticleAbstract() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.abstract").value("<p>this is an abstrat</p>\\r\\n<p>&nbsp;</p>\\r\\n<p><strong>wiht Bold text </strong></p>"));

    }

    @Test
    public void shouldReturnArticleCoverage() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.coverage").value("Coverage Information"));
    }


    @Test
    public void shouldReturnArticlePrefix() throws Exception {

        this.mockMvc.perform(get("/v1/article/2")).
                andExpect(jsonPath("$.prefix").value("the preifix"));

    }


}
