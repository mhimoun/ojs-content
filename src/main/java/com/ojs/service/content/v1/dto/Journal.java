package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by agile on 6/23/17.
 */
public class Journal extends ResourceSupport {
    private final int journalId;
    private final String path;


    public Journal(int journalId, String path) {
        this.journalId = journalId;
        this.path = path;

    }

    public int getJournalId() {
        return journalId;
    }

    public String getPath() {
        return path;
    }
}
