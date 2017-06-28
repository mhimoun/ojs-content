package com.ojs.service.content.v1.domain;


import javax.persistence.*;

@Entity @IdClass(JournalSettingsId.class)
public class JournalSettings {

    @Id
    @Column(name = "journal_id",insertable = false, updatable = false)
    private Long JournalId;

    @Id
    @Column
    private String locale;

    @Id
    @Column
    private String settingName;

    @Column
    private String settingValue;

    @Column
    private String settingType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journal_id",insertable = false, updatable = false)
    private Journals journal;


    public Long getJournalId() {
        return JournalId;
    }

    public String getLocale() {
        return locale;
    }

    public String getSettingName() {
        return settingName;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public String getSettingType() {
        return settingType;
    }

    public Journals getJournal() {
        return journal;
    }
}
