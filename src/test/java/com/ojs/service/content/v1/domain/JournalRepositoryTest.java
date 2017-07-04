package com.ojs.service.content.v1.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;
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
        assertThat(journals.get(0).getJournalSettings().size()).isGreaterThan(7);
    }

    @Test
    public void findByEnabled_shouldJournalSettingFields() throws Exception {
        List<Journals> journals = repository.findByEnabled(true);
        Map<String, JournalSettings> settingsMap = journals.get(0).getJournalSettings().stream().collect(toMap(JournalSettings::getSettingName, Function.identity()));
        JournalSettings settings = settingsMap.get("description");
        assertThat(settings.getJournalId()).isEqualTo(1);
        assertThat(settings.getLocale()).isEqualTo("en_US");
        assertThat(settings.getSettingName()).isEqualTo("description");
        assertThat(settings.getSettingValue()).isEqualTo("<p>the journal description</p>");
        assertThat(settings.getSettingType()).isEqualTo("string");
    }

    @Test
    public void findByJournalId_shouldReturnNullWhenJournalDoesNotExistInDb() throws Exception {

        Journals journal = repository.findByJournalId(145l);

        assertThat(journal).isNull();
    }

    @Test
    public void findByJournalId_shouldReturnOnlyEnabledJournals() throws Exception {

        Journals journal = repository.findByJournalId(3);

        assertThat(journal).isNull();
    }

    @Test
    public void findByJournalId_shouldReturnJournalWhenExistsInDb() throws Exception {

        Journals journal = repository.findByJournalId(1l);

        assertThat(journal).isNotNull();
        assertThat(journal.getJournalId()).isEqualTo(1l);

    }


    @Test
    public void findByJournalId_shouldJournalSettingFields() throws Exception {

        Journals journal = repository.findByJournalId(1l);

        assertThat(journal.getEnabled()).isTrue();
        assertThat(journal.getPath()).isEqualTo("path-context");
    }




}
