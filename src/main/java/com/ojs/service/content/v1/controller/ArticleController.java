package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Journal;
import com.ojs.service.content.v1.dto.Journals;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class ArticleController {


    @GetMapping("/v1/article")
    public String environments() {

        return "Hello";


    }

}
