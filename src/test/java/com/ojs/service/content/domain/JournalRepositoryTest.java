package com.ojs.service.content.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JournalRepositoryTest {

    @Autowired
    private JournalRepository repository;

    @Test
    public void findByEnabled_ShouldReturnAllEnabledJournals() throws Exception {
        List<Journals> journals = repository.findByEnabled(1);
        assertThat(journals.size()).isEqualTo(2);
    }

    @Test
    public void findByEnabled_shouldReturnJournalFields() throws Exception {
        List<Journals> journals = repository.findByEnabled(1);
        Journals journal = journals.get(0);
        assertThat(journal.getJournalId()).isEqualTo(1);
        assertThat(journal.getEnabled()).isEqualTo(1);
        assertThat(journal.getPath()).isEqualTo("path-context");
        assertThat(journal.getPrimaryLocale()).isEqualTo("en_US");
    }

    @Test
    public void findByEnabled_shouldReturnAllEnabledJournalsWithSetting() throws Exception {
        List<Journals> journals = repository.findByEnabled(1);
        assertNotNull("Journal setting must not be null", journals.get(0).getJournalSettings());
    }

    @Test
    public void findByEnabled_shouldJournalSettingFields() throws Exception {
        List<Journals> journals = repository.findByEnabled(1);
        JournalSettings settings = journals.get(0).getJournalSettings();
        assertThat(settings.getJournalId()).isEqualTo(1);
    }


}
