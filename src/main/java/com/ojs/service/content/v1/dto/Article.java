package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;


public class Article extends ResourceSupport {

    private final int journalId;
    private final int issueId;
    private final int articleId;


    public Article(int articleId, int issueId, int journalId) {
        this.journalId = journalId;
        this.issueId = issueId;
        this.articleId = articleId;
    }

    public int getJournalId() {
        return journalId;
    }

    public int getIssueId() {
        return issueId;
    }

    public int getArticleId() {
        return articleId;
    }
}
