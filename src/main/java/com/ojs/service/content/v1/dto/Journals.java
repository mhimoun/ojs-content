package com.ojs.service.content.v1.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

public class Journals extends ResourceSupport {

    Date updated = new Date();


    public Date getUpdated() {
        return updated;
    }
}
