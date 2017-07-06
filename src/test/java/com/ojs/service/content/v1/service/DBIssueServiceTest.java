package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.IssueRepository;
import com.ojs.service.content.v1.domain.IssueSettings;
import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.dto.Issue;
import com.ojs.service.content.v1.exception.IssueNotFoundException;
import com.ojs.service.content.v1.exception.JournalNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DBIssueServiceTest {

    IssueService issueService;



    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private IssueRepository issueRepository;

    @Before
    public void setup() {
        issueService = new DBIssueService(issueRepository);
    }

    @Test
    public void getPublishedIssues_shouldReturnEmptyListWhenNoPublishedIssues() throws Exception {

        List<Issue> issues = issueService.getPublishedIssues();

        assertThat(issues.size()).isEqualTo(0);

    }

    @Test
    public void getPublishedIssues_shouldCallIssueRepositoryWithPublishedAsTrue() throws Exception {

        List<Issue> issues = issueService.getPublishedIssues();

        assertThat(issues.size()).isEqualTo(0);

        verify(issueRepository).findByPublished(true);
    }

    @Test
    public void getPublishedIssues_shouldReturnResultsWhenIssuesPublishedInDB() throws Exception {

        when(issueRepository.findByPublished(true)).thenReturn(listOfDomainIssues());
        List<Issue> issues = issueService.getPublishedIssues();

        assertThat(issues.size()).isEqualTo(2);

    }


    @Test
    public void getPublishedIssues_shouldReturnIssuesWithJournalIdAndIssuesId() throws Exception {

        when(issueRepository.findByPublished(true)).thenReturn(listOfDomainIssues());
        List<Issue> issues = issueService.getPublishedIssues();

        assertThat(issues.get(0).getIssueId()).isEqualTo(1);
        assertThat(issues.get(1).getIssueId()).isEqualTo(2);
        assertThat(issues.get(0).getJournalId()).isEqualTo(1);
        assertThat(issues.get(1).getJournalId()).isEqualTo(2);

    }


    @Test
    public void getPublishedIssues_shouldIssueWithVolume() throws Exception {

        when(issueRepository.findByPublished(true)).thenReturn(listOfDomainIssues());
        List<Issue> issues = issueService.getPublishedIssues();

        assertThat(issues.get(0).getVolume()).isEqualTo((short)12);

    }


    @Test
    public void getJournalById_shouldThrowAnExceptionWhenIssueNotFound() throws Exception {

        this.thrown.expect(IssueNotFoundException.class);

        issueService.getIssueById(1);
    }


    @Test
    public void getIssueById_shouldReturnYearAndVolume() throws Exception {

        Issues issueDomain = new Issues(1, 1);
        issueDomain.setYear((short) 2014);
        issueDomain.setVolume((short) 12);
        when(issueRepository.findByIssueIdAndPublished(1, true)).thenReturn(issueDomain);
        Issue issue = issueService.getIssueById(1);

        assertThat(issue.getYear()).isEqualTo((short)2014);
        assertThat(issue.getVolume()).isEqualTo((short)12);

    }


    @Test
    public void getIssueById_shouldReturnIssueSettings() throws Exception {

        Issues issueDomain = new Issues(1, 1);
        IssueSettings title = new IssueSettings(1,"en","title","some title","string");
        IssueSettings description = new IssueSettings(1,"en","description","some description","string");
        List<IssueSettings> settings = Arrays.asList(title,description);
        issueDomain.setIssueSettings(settings);

        when(issueRepository.findByIssueIdAndPublished(1, true)).thenReturn(issueDomain);
        Issue issue = issueService.getIssueById(1);

        assertThat(issue.getTitle()).isEqualTo("some title");
        assertThat(issue.getDescription()).isEqualTo("some description");

    }

    private List<Issues> listOfDomainIssues() {

        Issues issue = new Issues(1,1);
        issue.setVolume((short) 12);
        Issues secondIssue = new Issues(2,2);
        return Arrays.asList(issue, secondIssue);
    }


}
