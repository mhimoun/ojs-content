package com.ojs.service.content.v1.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
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
        assertThat(issues.size()).isEqualTo(2);
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


    @Test
    public void findPublished_ShouldReturnIssuesIsCurrent() throws Exception {
        List<Issues> issues = repository.findByPublished(true);
        assertThat(issues.get(0).isCurrent()).isEqualTo(true);
        assertThat(issues.get(1).isCurrent()).isEqualTo(false);
    }

    @Test
    public void findPublished_ShouldReturnIssuesDates() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Issues> issues = repository.findByPublished(true);
        assertThat(issues.get(0).getDatePublished()).hasSameTimeAs(sdf.parse("2017-06-29 15:18:00"));
        assertThat(issues.get(0).getLastModified()).hasSameTimeAs(sdf.parse("2017-06-29 15:18:00"));
        assertThat(issues.get(0).getDateNotified()).hasSameTimeAs(sdf.parse("2017-07-22 11:12:05"));
        assertThat(issues.get(0).getOpenAccessDate()).hasSameTimeAs(sdf.parse("2017-07-07 07:07:07"));
    }

    @Test
    public void findPublished_ShouldReturnIssuesDInfo() throws Exception {
        List<Issues> issues = repository.findByPublished(true);
        assertThat(issues.get(0).getAccessStatus()).isEqualTo((short)1);
        assertThat(issues.get(0).isShowNumber()).isEqualTo(true);
        assertThat(issues.get(0).isShowTitle()).isEqualTo(true);
        assertThat(issues.get(0).isShowVolume()).isEqualTo(true);
        assertThat(issues.get(0).isShowYear()).isEqualTo(true);
        assertThat(issues.get(0).getOriginalStyleFileName()).isEqualTo("org file");
        assertThat(issues.get(0).getStyleFileName()).isEqualTo("file1");
    }


}
