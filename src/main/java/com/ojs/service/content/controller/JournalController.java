package com.ojs.service.content.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class JournalController {

    @GetMapping("/journal")
    public String environments() {
        return "journals";
    }

}
