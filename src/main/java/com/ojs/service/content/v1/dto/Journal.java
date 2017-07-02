package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;


public class Journal extends ResourceSupport {
    private final long journalId;
    private final String path;
    private String description;
    private String primaryLocale;
    private String onlineIssn;


    public Journal(long journalId, String path) {
        this.journalId = journalId;
        this.path = path;

    }

    public long getJournalId() {
        return journalId;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryLocale() {
        return primaryLocale;
    }

    public void setPrimaryLocale(String primaryLocale) {
        this.primaryLocale = primaryLocale;
    }

    public String getOnlineIssn() {
        return onlineIssn;
    }

    public void setOnlineIssn(String onlineIssn) {
        this.onlineIssn = onlineIssn;
    }
}
