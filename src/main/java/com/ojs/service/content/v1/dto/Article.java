package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;


public class Article extends ResourceSupport {

    private final long journalId;
    private final long issueId;
    private final long articleId;
    private Date datePublished;
    private String pages;


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

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}
