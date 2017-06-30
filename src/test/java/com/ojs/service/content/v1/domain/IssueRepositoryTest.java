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
        List<Issues> journals = repository.findByPublished(true);
        assertThat(journals.size()).isEqualTo(1);
    }


}
