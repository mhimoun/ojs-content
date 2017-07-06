package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Issue;
import com.ojs.service.content.v1.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/v1/issue")
public class IssueController {

    @Autowired
    private IssueService issueService;


    @GetMapping("/{issueId}")
    public Issue getIssueDefault(@PathVariable long issueId) {
        Issue issue = issueService.getIssueById(issueId);
        populateIssueHateoasLinks(issue, issueId);
        return issue;
    }

    private void populateIssueHateoasLinks(Issue issue, long issueId) {

        Link selfLink = linkTo(methodOn(IssueController.class).getIssueDefault(issueId)).withSelfRel();
        Link journalLink = linkTo(methodOn(JournalController.class).getJournalDefault(1)).withRel("journal");

        issue.add(selfLink);
        issue.add(journalLink);


    }

}
