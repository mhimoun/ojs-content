package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by agile on 6/23/17.
 */
public class Journal extends ResourceSupport {
    private final long journalId;
    private final String path;
    private String description;
    private String primaryLocale;


    public Journal(Long journalId, String path) {
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
}
