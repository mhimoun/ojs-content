package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Issue;
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
@RequestMapping("/v1/issue")
public class IssueController {


    @GetMapping("/{issueId}")
    public Issue getIssueDefault(@PathVariable int  issueId) {
        return new Issue(issueId,1);
    }
}
