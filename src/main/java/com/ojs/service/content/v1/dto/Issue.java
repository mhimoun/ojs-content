package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;


public class Issue extends ResourceSupport {
    private final int journalId;
    private final int issueId;

    public Issue(int issueId,int journalId) {
        this.issueId = issueId;
        this.journalId = journalId;
    }

    public int getJournalId() {
        return journalId;
    }

    public int getIssueId() {
        return issueId;
    }
}
