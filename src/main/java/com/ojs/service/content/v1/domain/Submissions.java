package com.ojs.service.content.v1.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Submissions {

    public Submissions(long submissionId) {
        this.submissionId = submissionId;
        this.publishedSubmission = new PublishedSubmissions();
    }

    @Id
    private long submissionId;

    @Column
    private String locale;

    @Column
    private long contextId;

    @Column
    private long sectionId;

    @Column
    private String language;

    @Column
    private String citations;


    @Column
    private Date dateSubmitted;

    @Column
    private Date lastModified;

    @Column
    private Date dateStatusModified;

    @Column
    short status;

    @Column
    short submissionProgress;

    @Column
    private short currentRound;

    @Column
    private String pages;

    @Column
    private short fastTracked;

    @Column
    private boolean hideAuthor;

    @Column
    private long stageId;

    @OneToOne(mappedBy = "submission")
    PublishedSubmissions publishedSubmission;

    public Submissions() {
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

    public long getContextId() {
        return contextId;
    }

    public void setContextId(long contextId) {
        this.contextId = contextId;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCitations() {
        return citations;
    }

    public void setCitations(String citations) {
        this.citations = citations;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getDateStatusModified() {
        return dateStatusModified;
    }

    public void setDateStatusModified(Date dateStatusModified) {
        this.dateStatusModified = dateStatusModified;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public short getSubmissionProgress() {
        return submissionProgress;
    }

    public void setSubmissionProgress(short submissionProgress) {
        this.submissionProgress = submissionProgress;
    }

    public short getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(short currentRound) {
        this.currentRound = currentRound;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public short getFastTracked() {
        return fastTracked;
    }

    public void setFastTracked(short fastTracked) {
        this.fastTracked = fastTracked;
    }

    public boolean isHideAuthor() {
        return hideAuthor;
    }

    public void setHideAuthor(boolean hideAuthor) {
        this.hideAuthor = hideAuthor;
    }

    public long getStageId() {
        return stageId;
    }

    public void setStageId(long stageId) {
        this.stageId = stageId;
    }

    public PublishedSubmissions getPublishedSubmission() {
        return publishedSubmission;
    }

    public void setPublishedSubmission(PublishedSubmissions publishedSubmission) {
        this.publishedSubmission = publishedSubmission;
    }
}
