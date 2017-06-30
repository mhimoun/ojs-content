package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.dto.Issue;

import java.util.ArrayList;
import java.util.List;


public class DBIssueService implements IssueService {


    @Override
    public List<Issue> getPublishedIssues() {
        return new ArrayList<>();
    }
}
