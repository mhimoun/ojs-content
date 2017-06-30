package com.ojs.service.content.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Issues {

    @Id
    private long issueId;

    @Column
    private long journalId;

    @Column
    private short volume;

    @Column
    private String number;

    @Column
    private short year;

    @Column
    private boolean published;


    @Column
    private boolean current;

    @Column
    private Date datePublished;

    @Column
    private Date dateNotified;

    @Column
    private Date lastModified;

    @Column
    private short accessStatus;

    @Column
    private Date openAccessDate;

    @Column
    private boolean showVolume;

    @Column
    private boolean showNumber;

    @Column
    private boolean showYear;

    @Column
    private boolean showTitle;

    @Column
    private String styleFileName;

    @Column
    private String originalStyleFileName;

    public Issues() {
    }

    public Issues(long issueId, long journalId) {

        this.issueId = issueId;
        this.journalId = journalId;

    }


    public long getIssueId() {
        return issueId;
    }

    public long getJournalId() {
        return journalId;
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

    public boolean isCurrent() {
        return current;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public Date getDateNotified() {
        return dateNotified;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public short getAccessStatus() {
        return accessStatus;
    }

    public Date getOpenAccessDate() {
        return openAccessDate;
    }

    public boolean isShowVolume() {
        return showVolume;
    }

    public boolean isShowNumber() {
        return showNumber;
    }

    public boolean isShowYear() {
        return showYear;
    }

    public boolean isShowTitle() {
        return showTitle;
    }

    public String getStyleFileName() {
        return styleFileName;
    }

    public String getOriginalStyleFileName() {
        return originalStyleFileName;
    }
}
