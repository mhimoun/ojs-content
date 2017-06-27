package com.ojs.service.content.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Journals {
    @Id
    @GeneratedValue
    private Long JournalId;

    @Column
    private String path;

    @Column
    private String seq;

    @Column
    private String primaryLocale;

   @Column
    private int enabled;



}
