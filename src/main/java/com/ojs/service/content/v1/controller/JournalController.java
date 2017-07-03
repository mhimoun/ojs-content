package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Journal;
import com.ojs.service.content.v1.dto.Journals;
import com.ojs.service.content.v1.exception.JournalNotFoundException;
import com.ojs.service.content.v1.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/v1/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    public Journals getJournals() {

        Link selfLink = linkTo(methodOn(JournalController.class).getJournals()).withSelfRel();

        Journals journals = new Journals();
        journals.add(selfLink);
        journals.addJournals(journalService.getEnabledJournals());

        return journals;


    }

    @GetMapping("/{journalId}")
    public Journal getJournalDefault(@PathVariable long journalId) {
        Link selfLink = linkTo(methodOn(JournalController.class).getJournalDefault(journalId)).withSelfRel();

        Journal journal =  journalService.getJournalById(journalId);
        journal.add(selfLink);
        return journal;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleVinNotFound(JournalNotFoundException ex) {
    }
}
