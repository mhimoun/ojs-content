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
        Journal journal =  journalService.getJournalById(journalId);


        Link selfLink = linkTo(methodOn(JournalController.class).getJournalDefault(journalId)).withSelfRel();
        journal.add(selfLink);

        Link journalsLink = linkTo(methodOn(JournalController.class).getJournals()).withRel("journals");
        journal.add(journalsLink);

        Link journalIssuesLink = linkTo(methodOn(JournalController.class).getJournalIssues(journalId)).withRel("issues");
        journal.add(journalIssuesLink);

        return journal;
    }


     @GetMapping("/{journalId}/issues")
    public Journal getJournalIssues(@PathVariable long journalId) {

         Journal journal = new Journal(journalId, null);

         Link selfLink = linkTo(methodOn(JournalController.class).getJournalIssues(journalId)).withSelfRel();
         journal.add(selfLink);

         Link journalLink = linkTo(methodOn(JournalController.class).getJournalDefault(journalId)).withRel("journal");
         journal.add(journalLink);

         return journal;
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleVinNotFound(JournalNotFoundException ex) {
    }
}
