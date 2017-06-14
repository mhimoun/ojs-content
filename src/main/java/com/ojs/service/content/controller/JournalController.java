package com.ojs.service.content.controller;


import com.ojs.service.content.dto.Journals;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JournalController {

    @GetMapping("/journal")
    public Journals environments() {
    return new Journals();
    }

}
