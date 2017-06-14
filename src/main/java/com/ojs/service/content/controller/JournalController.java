package com.ojs.service.content.controller;


import com.ojs.service.content.dto.Journals;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JournalController {

    @Value("${ojs.content.baseurl:localhost8080/v1/}")
    private String baseUrl;

    @GetMapping("/journal")
    public Journals environments() {
    return new Journals(baseUrl);
    }

}
