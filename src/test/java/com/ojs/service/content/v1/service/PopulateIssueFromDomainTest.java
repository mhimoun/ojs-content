package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.IssueSettings;
import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.domain.JournalSettings;
import com.ojs.service.content.v1.dto.Issue;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    public void shouldCreateIssueWithStatusAndStyleFileFromDomain() throws Exception {

        Issues issuesDomain = new Issues();
        issuesDomain.setAccessStatus((short) 5);
        issuesDomain.setStyleFileName("fileName");
        issuesDomain.setOriginalStyleFileName("org fileName");

        Issue issue = PopulateIssueFromDomain.valueOf(issuesDomain);

        assertThat(issue.getAccessStatus()).isEqualTo((short) 5);
        assertThat(issue.getStyleFileName()).isEqualTo("fileName");
        assertThat(issue.getOriginalStyleFileName()).isEqualTo("org fileName");

    }

    @Test
    public void shouldPopulateTitleAndDescription() throws Exception {

        Issues issuesDomain = new Issues();
        IssueSettings description = new IssueSettings(1l, "en-US", "description", "my description", "string");
        IssueSettings title = new IssueSettings(1l, "en-US", "title", "my title", "string");
        List<IssueSettings> settings = Arrays.asList(description,title);

        issuesDomain.setIssueSettings(settings);


        Issue issue = PopulateIssueFromDomain.valueOf(issuesDomain);

        assertThat(issue.getDescription()).isEqualTo("my description");
        assertThat(issue.getTitle()).isEqualTo("my title");

    }
    @Test
    public void shouldPopulateCoverImage() throws Exception {

        Issues issuesDomain = new Issues();
        IssueSettings coverImage = new IssueSettings(1l, "", "coverImage", "my-image", "string");
        IssueSettings coverImageAltText = new IssueSettings(1l, "en-US", "coverImageAltText", "my alt text", "string");
        List<IssueSettings> settings = Arrays.asList(coverImage,coverImageAltText);

        issuesDomain.setIssueSettings(settings);


        Issue issue = PopulateIssueFromDomain.valueOf(issuesDomain);

        assertThat(issue.getCoverImage()).isEqualTo("my-image");
        assertThat(issue.getCoverImageAltText()).isEqualTo("my alt text");

    }
  @Test
    public void shouldPopulatePublisherId() throws Exception {

        Issues issuesDomain = new Issues();
        IssueSettings pubId = new IssueSettings(1l, "", "pub-id::publisher-id", "publisher-id", "string");
        List<IssueSettings> settings = Arrays.asList(pubId);

        issuesDomain.setIssueSettings(settings);

        Issue issue = PopulateIssueFromDomain.valueOf(issuesDomain);
        assertThat(issue.getPublisherId()).isEqualTo("publisher-id");
    }

}
