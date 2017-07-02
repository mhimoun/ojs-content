package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.dto.Issue;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        issues.setVolume((short) 45);
        issues.setYear((short) 1945);
        issues.setNumber("11");
        Issue issue = PopulateIssueFromDomain.valueOf(issues);

        assertThat(issue.getVolume()).isEqualTo((short) 45);
        assertThat(issue.getYear()).isEqualTo((short) 1945);
        assertThat(issue.getNumber()).isEqualTo("11");

    }


    @Test
    public void shouldCreateIssueWithAllBooleanFieldsFromDomain() throws Exception {

        Issues issues = new Issues();
        issues.setPublished(true);
        issues.setCurrent(true);
        issues.setShowNumber(true);
        issues.setShowTitle(true);
        issues.setShowVolume(true);
        issues.setShowYear(true);
        Issue issue = PopulateIssueFromDomain.valueOf(issues);

        assertThat(issue.isPublished()).isEqualTo(true);
        assertThat(issue.isCurrent()).isEqualTo(true);
        assertThat(issue.isShowNumber()).isEqualTo(true);
        assertThat(issue.isShowTitle()).isEqualTo(true);
        assertThat(issue.isShowVolume()).isEqualTo(true);
        assertThat(issue.isShowYear()).isEqualTo(true);

    }

    @Test
    public void shouldCreateIssueWithAllDateFieldsFromDomain() throws Exception {
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-06-29 15:18:00");

        Issues issuesDomain = new Issues();
        issuesDomain.setDatePublished(expectedDate);
        issuesDomain.setDateNotified(expectedDate);
        issuesDomain.setOpenAccessDate(expectedDate);
        issuesDomain.setLastModified(expectedDate);

        Issue issue = PopulateIssueFromDomain.valueOf(issuesDomain);

        assertThat(issue.getDatePublished()).hasSameTimeAs(expectedDate);
        assertThat(issue.getDateNotified()).hasSameTimeAs(expectedDate);
        assertThat(issue.getOpenAccessDate()).hasSameTimeAs(expectedDate);
        assertThat(issue.getLastModified()).hasSameTimeAs(expectedDate);

    }

    @Test
    public void shouldCreateIssueWithSatusAndStyleFileFromDomain() throws Exception {

        Issues issuesDomain = new Issues();
        issuesDomain.setAccessStatus((short) 5);
        issuesDomain.setStyleFileName("fileName");
        issuesDomain.setOriginalStyleFileName("org fileName");

        Issue issue = PopulateIssueFromDomain.valueOf(issuesDomain);

        assertThat(issue.getAccessStatus()).isEqualTo((short) 5);
        assertThat(issue.getStyleFileName()).isEqualTo("fileName");
        assertThat(issue.getOriginalStyleFileName()).isEqualTo("org fileName");

    }

}
