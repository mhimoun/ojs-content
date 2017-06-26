package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Journal;
import com.ojs.service.content.v1.dto.Journals;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/v1/journal")
public class JournalController {


    @GetMapping
    public Journals getJournals() {

        Link selfLink = linkTo(methodOn(JournalController.class).getJournals()).withSelfRel();

        Journals journals = new Journals();
        journals.add(selfLink);
        Journal journal = new Journal(1, "my-path");
        journal.setDescription("my-description");
        Journal journal2 = new Journal(2, "my-second-path");
        journal2.setDescription("my-description2");
        journals.addJournal(journal);
        journals.addJournal(journal2);

        return journals;


    }


    @GetMapping("/{journalId}")
    public Journal getJournalDefault(@PathVariable int  journalId) {
        Link selfLink = linkTo(methodOn(JournalController.class).getJournalDefault(journalId)).withSelfRel();

        Journal journal = new Journal(journalId, "my-path");
        journal.setDescription("my-description");
        journal.add(selfLink);
        return journal;
    }
}
