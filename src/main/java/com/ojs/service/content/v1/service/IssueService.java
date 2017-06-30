package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.dto.Issue;

import java.util.List;

public interface IssueService {

    List<Issue> getPublishedIssues();
}
