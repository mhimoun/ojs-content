package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import java.util.Date;


public class Issue extends ResourceSupport {
    private long journalId;
    private long issueId;
    private String title;
    private String description;

    private short volume;
    private String number;
    private short year;
    private boolean published;
    private boolean current;
    private Date datePublished;
    private Date dateNotified;
    private Date lastModified;
    private short accessStatus;
    private Date openAccessDate;
    private boolean showVolume;
    private boolean showNumber;
    private boolean showYear;
    private boolean showTitle;
    private String styleFileName;
    private String originalStyleFileName;
    private String coverImage;
    private String coverImageAltText;

    public Issue(long issueId, long journalId) {
        this.issueId = issueId;
        this.journalId = journalId;
    }

    public Issue() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getJournalId() {
        return journalId;
    }

    public long getIssueId() {
        return issueId;
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

    public String getStyleFileName() {
        return styleFileName;
    }

    public String getOriginalStyleFileName() {
        return originalStyleFileName;
    }

    public void setJournalId(long journalId) {
        this.journalId = journalId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCoverImageAltText() {
        return coverImageAltText;
    }

    public void setCoverImageAltText(String coverImageAltText) {
        this.coverImageAltText = coverImageAltText;
    }
}
