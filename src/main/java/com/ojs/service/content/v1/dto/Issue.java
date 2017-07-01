package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;


public class Issue extends ResourceSupport {
    private long journalId;
    private long issueId;
    private short volume;
    private String number;
    private short year;
    private boolean published;

    public Issue(long issueId, long journalId) {
        this.issueId = issueId;
        this.journalId = journalId;
    }

    public Issue() {
    }

    public long getJournalId() {
        return journalId;
    }

    public long getIssueId() {
        return issueId;
    }

    public short getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public short getYear() {
        return year;
    }

    public boolean isPublished() {
        return published;
    }

    public void setJournalId(long journalId) {
        this.journalId = journalId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public void setVolume(short volume) {
        this.volume = volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
