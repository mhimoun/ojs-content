package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.JournalRepository;
import com.ojs.service.content.v1.domain.JournalSettings;
import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;
import com.ojs.service.content.v1.exception.JournalNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException thrown = ExpectedException.none();


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
        assertThat(enabledJournals.get(0).getSearchDescription()).isEqualTo("my-description");

    }

    @Test
    public void getJournalById_shouldThrowAnExceptionWhenJournalNotFound() throws Exception {

        this.thrown.expect(JournalNotFoundException.class);

        journalService.getJournalById(1l);
    }


    @Test
    public void getJournalById_shouldReturnJournalWhenFoundInDB() throws Exception {

        when(journalRepository.findByJournalIdAndEnabled(5l, true)).thenReturn(new Journals(5l, "some-path", "en"));

        Journal journal = journalService.getJournalById(5l);

        assertThat(journal.getJournalId()).isEqualTo(5l);
        assertThat(journal.getPath()).isEqualTo("some-path");
        assertThat(journal.getPrimaryLocale()).isEqualTo("en");
    }

    private List<Journals> listDomainJournals() {

        List<Journals> journals = new ArrayList<>();

        Journals journal = new Journals(1l, "path1", "en-US");
        JournalSettings searchDescription = new JournalSettings(1l, "en-US", "searchDescription", "my-description", "string");
        JournalSettings donationFeeName = new JournalSettings(1l, "en-US", "donationFeeName", "Donations to journal", "string");
        List<JournalSettings> settings = Arrays.asList(searchDescription, donationFeeName);
        journal.setJournalSettings(settings);
        journals.add(journal);
        journals.add(new Journals(12l, "path2", "en-UK"));
        return journals;
    }


}