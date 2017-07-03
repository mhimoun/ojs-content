package com.ojs.service.content.v1.domain;


import javax.persistence.*;

@Entity @IdClass(JournalSettingsId.class)
public class JournalSettings {

    @Id
    @Column(name = "journal_id",insertable = false, updatable = false)
    private Long journalId;

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


    public JournalSettings(Long journalId, String locale, String settingName, String settingValue, String settingType) {
        this.journalId = journalId;
        this.locale = locale;
        this.settingName = settingName;
        this.settingValue = settingValue;
        this.settingType = settingType;
    }

    public JournalSettings(){}

    public Long getJournalId() {
        return journalId;
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
