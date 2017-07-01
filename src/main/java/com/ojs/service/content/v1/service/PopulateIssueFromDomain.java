package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.dto.Issue;
import org.springframework.beans.BeanUtils;

public class PopulateIssueFromDomain {
    public static Issue valueOf(Issues issuesDomain) {

        Issue issue = new Issue();
        BeanUtils.copyProperties(issuesDomain, issue);
        return issue;
    }
}
