package com.ojs.service.content.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class PublishedSubmissions {

    @Id
    private long publishedSubmissionId;

    @Column
    private long submissionId;

    @Column
    private long issueId;

    @Column
    private Date datePublished;

    @Column
    private long seq;

    @Column
    private short accessStatus;


    @OneToOne(mappedBy = "publishedSubmission")
    private Submissions submission;


    public PublishedSubmissions(long publishedSubmissionId, long submissionId, long issueId, Date datePublished, long seq, short accessStatus) {
        this.publishedSubmissionId = publishedSubmissionId;
        this.submissionId = submissionId;
        this.issueId = issueId;
        this.datePublished = datePublished;
        this.seq = seq;
        this.accessStatus = accessStatus;
    }

    public PublishedSubmissions() {

    }


    public long getPublishedSubmissionId() {
        return publishedSubmissionId;
    }

    public void setPublishedSubmissionId(long publishedSubmissionId) {
        this.publishedSubmissionId = publishedSubmissionId;
    }

    public long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(long submissionId) {
        this.submissionId = submissionId;
    }

    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public short getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(short accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Submissions getSubmission() {
        return submission;
    }

    public void setSubmission(Submissions submission) {
        this.submission = submission;
    }
}
