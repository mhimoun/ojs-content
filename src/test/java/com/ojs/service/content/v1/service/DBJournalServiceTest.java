package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.JournalRepository;
import com.ojs.service.content.v1.domain.JournalSettings;
import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DBJournalServiceTest {

    @Mock
    private JournalRepository journalRepository;


    JournalService journalService;

    @Before
    public void setup() {
        journalService = new DBJournalService(journalRepository);
    }


    @Test
    public void getEnabledJournals_ShouldReturnEmptyListWhenNoEnabledJournals() throws Exception {

        List<Journal> enabledJournals = journalService.getEnabledJournals();

        assertThat(enabledJournals.size()).isEqualTo(0);

    }

    @Test
    public void getEnabledJournals_ShouldCallRepositoryWithEnabled() throws Exception {

        List<Journal> enabledJournals = journalService.getEnabledJournals();
        assertThat(enabledJournals.size()).isEqualTo(0);

        verify(journalRepository).findByEnabled(true);

    }


    @Test
    public void getEnabledJournals_ShouldReturnResultsWhenJournalsInDB() throws Exception {

        when(journalRepository.findByEnabled(true)).thenReturn(listDomainJournals());

        List<Journal> enabledJournals = journalService.getEnabledJournals();

        assertThat(enabledJournals.size()).isEqualTo(2);

    }


    @Test
    public void getEnabledJournals_ShouldReturnJournalDetails() throws Exception {

        when(journalRepository.findByEnabled(true)).thenReturn(listDomainJournals());

        List<Journal> enabledJournals = journalService.getEnabledJournals();

        assertThat(enabledJournals.get(1).getJournalId()).isEqualTo(12);
        assertThat(enabledJournals.get(0).getPath()).isEqualTo("path1");
        assertThat(enabledJournals.get(0).getPrimaryLocale()).isEqualTo("en-US");
        assertThat(enabledJournals.get(0).getDescription()).isEqualTo("my-description");

    }


    private List<Journals> listDomainJournals() {

        List<Journals> journals = new ArrayList<>();

        Journals journal = new Journals(1l, "path1", "en-US");
        JournalSettings description = new JournalSettings(1l, "en-US", "description", "my-description", "string");
        JournalSettings donationFeeName = new JournalSettings(1l, "en-US", "donationFeeName", "Donations to journal", "string");
        List<JournalSettings> settings = Arrays.asList(description, donationFeeName);
        journal.setJournalSettings(settings);
        journals.add(journal);
        journals.add(new Journals(12l, "path2", "en-UK"));
        return journals;
    }


}