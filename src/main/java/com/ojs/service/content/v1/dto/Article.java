package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;


public class Article extends ResourceSupport {

    private final long journalId;
    private final long issueId;
    private final long articleId;


    public Article(long articleId, long issueId, long journalId) {
        this.journalId = journalId;
        this.issueId = issueId;
        this.articleId = articleId;
    }

    public long getJournalId() {
        return journalId;
    }

    public long getIssueId() {
        return issueId;
    }

    public long getArticleId() {
        return articleId;
    }
}
