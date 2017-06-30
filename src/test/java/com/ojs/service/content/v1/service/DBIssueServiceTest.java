package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.dto.Issue;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DBIssueServiceTest {


    IssueService issueService;

    @Before
    public void setup() {
        issueService = new DBIssueService();
    }


    @Test
    public void shouldReturnEmptyListWhenNoPublishedIssues() throws Exception {


        List<Issue> issues = issueService.getPublishedIssues();

        assertThat(issues.size()).isEqualTo(0);

    }

}
