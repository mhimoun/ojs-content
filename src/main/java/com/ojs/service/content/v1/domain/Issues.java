package com.ojs.service.content.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "issues")
    List<IssueSettings> issueSettings;


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

    public void setVolume(short volume) {
        this.volume = volume;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public void setDateNotified(Date dateNotified) {
        this.dateNotified = dateNotified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setAccessStatus(short accessStatus) {
        this.accessStatus = accessStatus;
    }

    public void setOpenAccessDate(Date openAccessDate) {
        this.openAccessDate = openAccessDate;
    }

    public void setShowVolume(boolean showVolume) {
        this.showVolume = showVolume;
    }

    public void setShowNumber(boolean showNumber) {
        this.showNumber = showNumber;
    }

    public void setShowYear(boolean showYear) {
        this.showYear = showYear;
    }

    public void setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
    }

    public void setStyleFileName(String styleFileName) {
        this.styleFileName = styleFileName;
    }

    public void setOriginalStyleFileName(String originalStyleFileName) {
        this.originalStyleFileName = originalStyleFileName;
    }

    public List<IssueSettings> getIssueSettings() {
        return issueSettings;
    }

    public void setIssueSettings(List<IssueSettings> issueSettings) {
        this.issueSettings = issueSettings;
    }
}
