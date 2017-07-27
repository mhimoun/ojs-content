package com.ojs.service.content.v1.domain;

import javax.persistence.*;

@Entity
@IdClass(SubmissionsSettingsId.class)
public class SubmissionSettings {
    @Id
    @Column(name = "submission_id", insertable = false, updatable = false)
    private long submissionId;

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
    @JoinColumn(name = "submission_id", insertable = false, updatable = false)
    private Submissions submissions;

    public SubmissionSettings(long submissionId, String locale, String settingName, String settingValue, String settingType) {
        this.submissionId = submissionId;
        this.locale = locale;
        this.settingName = settingName;
        this.settingValue = settingValue;
        this.settingType = settingType;
    }

    public SubmissionSettings() {
    }

    public long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(long submissionId) {
        this.submissionId = submissionId;
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

    public Submissions getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Submissions submissions) {
        this.submissions = submissions;
    }
}
