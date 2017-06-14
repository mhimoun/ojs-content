package com.ojs.service.content.dto;

public class Journals {


    private String linkToSelf;

    public Journals(String baseUrl) {
        this.linkToSelf = baseUrl + "journal";
    }


    public String getLinkToSelf() {
        return linkToSelf;
    }

    public void setLinkToSelf(String linkToSelf) {
        this.linkToSelf = linkToSelf;
    }
}
