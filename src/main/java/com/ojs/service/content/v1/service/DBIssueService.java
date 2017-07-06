package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.IssueRepository;
import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.dto.Issue;
import com.ojs.service.content.v1.exception.IssueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBIssueService implements IssueService {

    @Autowired
    private final IssueRepository issueRepository;

    public DBIssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public List<Issue> getPublishedIssues() {

        ArrayList<Issue> issues = new ArrayList<>();

        List<Issues> domainIssues = issueRepository.findByPublished(true);

        for (Issues di : domainIssues) {
            issues.add(PopulateIssueFromDomain.valueOf(di));
        }

        return issues;
    }

    @Override
    public Issue getIssueById(long issueId) {
        Issues byIssueIdAndPublished = issueRepository.findByIssueIdAndPublished(issueId, true);

        if (byIssueIdAndPublished == null) throw new IssueNotFoundException(issueId);

        return PopulateIssueFromDomain.valueOf(byIssueIdAndPublished);
    }


}
