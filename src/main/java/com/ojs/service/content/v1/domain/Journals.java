package com.ojs.service.content.v1.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Journals {
    @Id
    private long journalId;

    @Column
    private String path;

    @Column
    private long seq;

    @Column
    private String primaryLocale;

    @Column
    private boolean enabled;

    public Journals(long journalId, String path, String primaryLocale) {
        this.journalId = journalId;
        this.path = path;
        this.primaryLocale = primaryLocale;
    }

    public Journals() {
    }

    @OneToMany(mappedBy = "journal")
    List<JournalSettings> journalSettings;


    public long getJournalId() {
        return journalId;
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

    public boolean getEnabled() {
        return enabled;
    }

    public List<JournalSettings> getJournalSettings() {
        return journalSettings;
    }

    public void setJournalSettings(List<JournalSettings> journalSettings) {
        this.journalSettings = journalSettings;
    }
}
