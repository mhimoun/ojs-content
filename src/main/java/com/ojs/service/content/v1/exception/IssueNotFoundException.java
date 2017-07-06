package com.ojs.service.content.v1.exception;


public class IssueNotFoundException extends RuntimeException {


    public IssueNotFoundException(long issueId) {
        super("issue not found for ID " + issueId);
    }
}
