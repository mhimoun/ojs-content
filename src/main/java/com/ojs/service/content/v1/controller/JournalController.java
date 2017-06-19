package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Journals;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class JournalController {


    @GetMapping("/v1/journal")
    public Journals environments() {

        Link selfLink = linkTo(methodOn(JournalController.class).environments()).withSelfRel();

        Journals journals = new Journals();
        journals.add(selfLink);

        return journals;


    }

}
