package com.ojs.service.content.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Issues {

    @Id
    private Long issueId;

    @Column
    private Long journalId;

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
    private Date date_published;

    @Column
    private Date date_notified;

    @Column
    private Date last_modified;

    @Column
    private short access_status;

    @Column
    private Date open_access_date;

    @Column
    private boolean show_volume;

    @Column
    private boolean show_number;

    @Column
    private boolean show_year;

    @Column
    private boolean show_title;

    @Column
    private String style_file_name;

    @Column
    private String original_style_file_name;

    public Issues() {
    }

}
