package com.ojs.service.content.v1.controller;


import com.ojs.service.content.v1.domain.Issues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200OKResponseOnDefaultIssueEndpoint() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnJsonResponse() throws Exception {

        this.mockMvc.perform(get("/v1/issue/3")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }


    @Test
    public void shouldReturnLinkToSelf() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.links[?(@.rel=='self')].href").value(("http://localhost/v1/issue/1")));
    }

    @Test
    public void shouldReturnLinkToJournal() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.links[?(@.rel=='journal')].href").value(("http://localhost/v1/journal/1")));
    }


    @Test
    public void shouldReturnJournalId() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.journalId").value(1));
    }

    @Test
    public void shouldReturnIssueId() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.issueId").value(1));
    }

    @Test
    public void shouldReturnMainIssueInfo() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.volume").value(3)).
                andExpect(jsonPath("$.year").value(2016)).
                andExpect(jsonPath("$.published").value("true")).
                andExpect(jsonPath("$.title").value("The title of the issue")).
                andExpect(jsonPath("$.description").value("<p>some description of the issue</p>")).
                andExpect(jsonPath("$.datePublished").value("29-06-2017 15:18:00")).
                andExpect(jsonPath("$.number").value("12"));
    }

    @Test
    public void shouldReturnExtraIssueInfo() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.accessStatus").value(1)).
                andExpect(jsonPath("$.showNumber").value("true")).
                andExpect(jsonPath("$.showTitle").value("true")).
                andExpect(jsonPath("$.showVolume").value("true")).
                andExpect(jsonPath("$.showYear").value("true")).
                andExpect(jsonPath("$.current").value("true")).
                andExpect(jsonPath("$.originalStyleFileName").value("org file")).
                andExpect(jsonPath("$.styleFileName").value("file1"));
    }

    @Test
    public void shouldReturnIssueDates() throws Exception {

        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.datePublished").value("29-06-2017 15:18:00")).
                andExpect(jsonPath("$.lastModified").value("29-06-2017 15:18:00")).
                andExpect(jsonPath("$.dateNotified").value("22-07-2017 11:12:05")).
                andExpect(jsonPath("$.openAccessDate").value("07-07-2017 07:07:07"));
    }

    @Test
    public void shouldReturn404NotFoundResponseWhenIssueDoesNotExistInDb() throws Exception {
        this.mockMvc.perform(get("/v1/issue/404")).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn404NotFoundResponseWhenIssueIsNotPublished() throws Exception {
        this.mockMvc.perform(get("/v1/issue/2")).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnIssueCoverImage() throws Exception {
        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.coverImage").value("cover_issue_1_en_US.jpg")).
                andExpect(jsonPath("$.coverImageAltText").value("Alternate text"));
    }

    @Test
    public void shouldReturnIssuePublisherId() throws Exception {
        this.mockMvc.perform(get("/v1/issue/1")).
                andExpect(jsonPath("$.publisherId").value("http://localhost/ojs/index.php/issue-public-url-id"));
    }


}
