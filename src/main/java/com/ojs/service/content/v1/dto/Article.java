package com.ojs.service.content.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;


public class Article extends ResourceSupport {

    private final long journalId;
    private final long issueId;
    private final long articleId;
    private Date datePublished;
    private String pages;
    private String title;
    private String copyrightYear;

    @JsonProperty("abstract")
    private String articleAbstract;
    private String cleanTitle;
    private String subTitle;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    public String getCleanTitle() {
        return cleanTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
