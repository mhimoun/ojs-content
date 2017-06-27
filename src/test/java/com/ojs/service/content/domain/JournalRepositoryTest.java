package com.ojs.service.content.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JournalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private JournalRepository repository;



    @Test
    public void ShouldReturnAllEnabledJournals() throws Exception {
     List<Journals> journals  =   repository.findByEnabled(1);
        assertThat(journals.size()).isEqualTo(2);
    }



}
