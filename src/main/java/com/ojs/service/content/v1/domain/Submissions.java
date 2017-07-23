package com.ojs.service.content.v1.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Submissions {

    @Id
    private long submissionId;

    @Column
    private String locale;

    @Column
    private long issueId;

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

    @OneToOne
    @JoinColumn(name = "publishedSubmissionId")
    PublishedSubmissions publishedSubmission;
}
