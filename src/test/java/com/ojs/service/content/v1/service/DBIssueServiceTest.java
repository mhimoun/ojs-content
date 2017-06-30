package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.IssueRepository;
import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.dto.Issue;
import org.junit.Before;
import org.junit.Test;
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



    private List<Issues> listOfDomainIssues() {

        Issues issue = new Issues(1,1);

        Issues secondIssue = new Issues(2,2);
        return Arrays.asList(issue, secondIssue);
    }


}
