package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.JournalRepository;
import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
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

        verify(journalRepository).findByEnabled(1);

    }



    @Test
    public void getEnabledJournals_ShouldReturnResultsWhenJournalsInDB() throws Exception {

        when(journalRepository.findByEnabled(1)).thenReturn(listDomainJournals());

        List<Journal> enabledJournals = journalService.getEnabledJournals();

        assertThat(enabledJournals.size()).isEqualTo(2);

    }




    private List<Journals> listDomainJournals() {

        List<Journals> journals = new ArrayList<>();

        journals.add(new Journals());
        journals.add(new Journals());
        return  journals;
    }


}