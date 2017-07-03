package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;


public class Journal extends ResourceSupport {
    private final long journalId;
    private final String path;
    private String description;
    private String primaryLocale;
    private String onlineIssn;
    private String printIssn;
    private String abbreviation;
    private String name;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String contactTitle;
    private String contactAffiliation;
    private String searchDescription;


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

    public String getPrintIssn() {
        return printIssn;
    }

    public void setPrintIssn(String printIssn) {
        this.printIssn = printIssn;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContactAffiliation() {
        return contactAffiliation;
    }

    public void setContactAffiliation(String contactAffiliation) {
        this.contactAffiliation = contactAffiliation;
    }

    public String getSearchDescription() {
        return searchDescription;
    }

    public void setSearchDescription(String searchDescription) {
        this.searchDescription = searchDescription;
    }
}
