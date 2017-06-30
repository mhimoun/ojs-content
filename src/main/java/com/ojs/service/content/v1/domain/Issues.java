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


    public Long getIssueId() {
        return issueId;
    }

    public Long getJournalId() {
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

    public Date getDate_published() {
        return date_published;
    }

    public Date getDate_notified() {
        return date_notified;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public short getAccess_status() {
        return access_status;
    }

    public Date getOpen_access_date() {
        return open_access_date;
    }

    public boolean isShow_volume() {
        return show_volume;
    }

    public boolean isShow_number() {
        return show_number;
    }

    public boolean isShow_year() {
        return show_year;
    }

    public boolean isShow_title() {
        return show_title;
    }

    public String getStyle_file_name() {
        return style_file_name;
    }

    public String getOriginal_style_file_name() {
        return original_style_file_name;
    }
}
