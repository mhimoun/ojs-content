package com.ojs.service.content.v1.domain;


import javax.persistence.*;

@Entity @IdClass(IssueSettingsId.class)
public class IssueSettings {

    @Id
    @Column(name = "issue_id",insertable = false, updatable = false)
    private long issueId;

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
    @JoinColumn(name = "issue_id",insertable = false, updatable = false)
    private Issues issues;

    public IssueSettings(long issueId, String locale, String settingName, String settingValue, String settingType) {
        this.issueId = issueId;
        this.locale = locale;
        this.settingName = settingName;
        this.settingValue = settingValue;
        this.settingType = settingType;
    }

    public IssueSettings() {
    }


    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    public String getSettingType() {
        return settingType;
    }

    public void setSettingType(String settingType) {
        this.settingType = settingType;
    }

    public Issues getIssues() {
        return issues;
    }

    public void setIssues(Issues issues) {
        this.issues = issues;
    }
}
