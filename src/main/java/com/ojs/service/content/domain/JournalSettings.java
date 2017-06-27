package com.ojs.service.content.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JournalSettings {

    @Id
    @Column
    private Long JournalId;

    @Column
    private String locale;

    @Column
    private String settingName;

    @Column
    private String settingValue;

    @Column
    private String settingType;


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
}
