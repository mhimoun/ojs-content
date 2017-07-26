package com.ojs.service.content.v1.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.ojs.service.content.v1.domain.ArticleRepository.ARTICLE_STATUS_PUBLISHED;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryTest {


    @Autowired
    private ArticleRepository repository;

    @Test
    public void findPublished_ShouldReturnAllPublishedIssues() throws Exception {
        List<Submissions> submissions = repository.findByStatus(ARTICLE_STATUS_PUBLISHED);
        assertThat(submissions.size()).isEqualTo(1);
    }

    @Test
    public void findBySubmissionIdAndStatus_ShouldReturnArticleById() throws Exception {
        Submissions submissions = repository.findBySubmissionIdAndStatus(2, ARTICLE_STATUS_PUBLISHED);
        assertThat(submissions.getSubmissionId()).isEqualTo(2);
    }


    @Test
    public void findBySubmissionIdAndStatus_ShouldReturnPublishedSubmissionDetails() throws Exception {
        Submissions submissions = repository.findBySubmissionIdAndStatus(2, ARTICLE_STATUS_PUBLISHED);
        assertThat(submissions.getPublishedSubmission()).isNotNull();
        assertThat(submissions.getPublishedSubmission().getSubmissionId()).isEqualTo(2);
        assertThat(submissions.getPublishedSubmission().getIssueId()).isEqualTo(1);
    }


}