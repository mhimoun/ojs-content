package com.ojs.service.content.v1.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.ojs.service.content.v1.domain.ArticleRepository.ARTICLE_STATUS_PUBLISHED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by miloud on 23/07/17.
 */
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


}