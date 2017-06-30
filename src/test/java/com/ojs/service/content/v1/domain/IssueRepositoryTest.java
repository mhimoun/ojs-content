package com.ojs.service.content.v1.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueRepositoryTest {

    @Autowired
    private IssueRepository repository;

    @Test
    public void findPublished_ShouldReturnAllPublishedIssues() throws Exception {
        List<Issues> issues = repository.findByPublished(true);
        assertThat(issues.size()).isEqualTo(1);
    }

    @Test
    public void findPublished_ShouldReturnIssuesMainDetails() throws Exception {
        List<Issues> issues = repository.findByPublished(true);
        assertThat(issues.get(0).getIssueId()).isEqualTo(1);
        assertThat(issues.get(0).getJournalId()).isEqualTo(1);
        assertThat(issues.get(0).isPublished()).isEqualTo(true);
        assertThat(issues.get(0).getVolume()).isEqualTo((short) 3);
        assertThat(issues.get(0).getNumber()).isEqualTo("12");
        assertThat(issues.get(0).getYear()).isEqualTo((short) 2016);
    }


}
