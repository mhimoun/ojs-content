package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.dto.Issue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PopulateIssueFromDomainTest {



    @Test
    public void shouldCreateIssueWithJournalIdandIssueId() throws Exception {

        Issue issue = PopulateIssueFromDomain.valueOf(new Issues(10, 5));

        assertThat(issue.getIssueId()).isEqualTo(10);
        assertThat(issue.getJournalId()).isEqualTo(5);

    }


    @Test
    public void shouldCreateIssueWithVolumeYearAndNumber() throws Exception {

        Issues issues = new Issues(10, 5);
        issues.setVolume((short)45);
        issues.setYear((short) 1945);
        issues.setNumber("11");
        Issue issue = PopulateIssueFromDomain.valueOf(issues);

        assertThat(issue.getVolume()).isEqualTo((short)45);
        assertThat(issue.getYear()).isEqualTo((short)1945);
        assertThat(issue.getNumber()).isEqualTo("11");

    }



}
