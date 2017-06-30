package com.ojs.service.content.v1.domain;


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
        List<Journals> journals = repository.findByEnabled(true);
        assertThat(journals.size()).isEqualTo(2);
    }

    @Test
    public void findByEnabled_shouldReturnJournalFields() throws Exception {
        List<Journals> journals = repository.findByEnabled(true);
        Journals journal = journals.get(0);
        assertThat(journal.getJournalId()).isEqualTo(1);
        assertThat(journal.getEnabled()).isEqualTo(true);
        assertThat(journal.getSeq()).isEqualTo(1);
        assertThat(journal.getPath()).isEqualTo("path-context");
        assertThat(journal.getPrimaryLocale()).isEqualTo("en_US");
        assertThat(journal.getPrimaryLocale()).isEqualTo("en_US");
    }

    @Test
    public void findByEnabled_shouldReturnAllEnabledJournalsWithSetting() throws Exception {
        List<Journals> journals = repository.findByEnabled(true);
        assertNotNull("Journal setting must not be null", journals.get(0).getJournalSettings());
        assertThat(journals.get(0).getJournalSettings().size()).isEqualTo(7);
    }

    @Test
    public void findByEnabled_shouldJournalSettingFields() throws Exception {
        List<Journals> journals = repository.findByEnabled(true);
        JournalSettings settings = journals.get(0).getJournalSettings().get(3);
        assertThat(settings.getJournalId()).isEqualTo(1);
        assertThat(settings.getLocale()).isEqualTo("en_US");
        assertThat(settings.getSettingName()).isEqualTo("description");
        assertThat(settings.getSettingValue()).isEqualTo("<p>the journal description</p>");
        assertThat(settings.getSettingType()).isEqualTo("string");
    }


}
