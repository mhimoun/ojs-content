package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;


public class Issue extends ResourceSupport {
    private final long journalId;
    private final long issueId;

    public Issue(long issueId,long journalId) {
        this.issueId = issueId;
        this.journalId = journalId;
    }

    public long getJournalId() {
        return journalId;
    }

    public long getIssueId() {
        return issueId;
    }
}
