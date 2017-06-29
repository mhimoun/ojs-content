package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journals extends ResourceSupport {

    Date updated = new Date();
    List<Journal> journals;


    public Date getUpdated() {
        return updated;
    }

    public void addJournals(List<Journal> journalsToAdd) {
        if (journals == null) {
            journals = new ArrayList<>();
        }

        journals.addAll(journalsToAdd);
    }

    public List<Journal> getJournals() {
        return journals;
    }
}
