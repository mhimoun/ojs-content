package com.ojs.service.content.v1.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Journals {
    @Id
    private Long JournalId;

    @Column
    private String path;

    @Column
    private Long seq;

    @Column
    private String primaryLocale;

    @Column
    private int enabled;

    public Journals(Long journalId, String path, String primaryLocale) {
        JournalId = journalId;
        this.path = path;
        this.primaryLocale = primaryLocale;
    }

    public Journals() {
    }

    @OneToMany(mappedBy = "journal")
    List<JournalSettings> journalSettings;


    public Long getJournalId() {
        return JournalId;
    }

    public String getPath() {
        return path;
    }

    public Long getSeq() {
        return seq;
    }

    public String getPrimaryLocale() {
        return primaryLocale;
    }

    public int getEnabled() {
        return enabled;
    }

    public List<JournalSettings> getJournalSettings() {
        return journalSettings;
    }

    public void setJournalSettings(List<JournalSettings> journalSettings) {
        this.journalSettings = journalSettings;
    }
}
