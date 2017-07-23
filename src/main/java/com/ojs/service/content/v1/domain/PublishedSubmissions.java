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

}
