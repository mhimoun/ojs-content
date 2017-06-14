package com.ojs.service.content.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JournalControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private String baseurl = "http://localhost/v1/";


    @Test
    public void shouldReturn200OKResponseOnDefaultJournalEndpoint() throws Exception {

        this.mockMvc.perform(get("/journal")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnJsonResponse() throws Exception {

        this.mockMvc.perform(get("/journal")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

        @Test
    public void shouldReturnLinkToSelf() throws Exception {

        this.mockMvc.perform(get("/journal")).
                andExpect(jsonPath("$.linkToSelf" , is (baseurl +"journal") ));
    }


}
