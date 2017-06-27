package com.ojs.service.content.domain;

import javax.persistence.*;

@Entity
public class Journals {
    @Id
    @GeneratedValue
    private Long JournalId;

    @Column
    private String path;

    @Column
    private String seq;

    @Column
    private String primaryLocale;

    @Column
    private int enabled;

    @OneToOne
    @JoinColumn(name="journal_id")
    JournalSettings journalSettings;


    public Long getJournalId() {
        return JournalId;
    }

    public String getPath() {
        return path;
    }

    public String getSeq() {
        return seq;
    }

    public String getPrimaryLocale() {
        return primaryLocale;
    }

    public int getEnabled() {
        return enabled;
    }

    public JournalSettings getJournalSettings() {
        return journalSettings;
    }
}
