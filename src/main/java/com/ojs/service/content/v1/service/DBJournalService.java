package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.JournalRepository;
import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;
import com.ojs.service.content.v1.exception.JournalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBJournalService implements JournalService {

    public static final boolean JOURNAL_IS_ENABLED = true ;
    public static final boolean INCLUDE_ALL_JOURNAL_FIELDS = true ;
    private JournalRepository journalRepository;

    @Autowired
    public DBJournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }


    @Override
    public List<Journal> getEnabledJournals() {

        List<Journal> dtoJournals = new ArrayList<>();

        List<Journals> domainJournals = journalRepository.findByEnabled(JOURNAL_IS_ENABLED);

        for (Journals dj : domainJournals) {
            dtoJournals.add(PopulateJournalFromDomain.valueOf(dj, !INCLUDE_ALL_JOURNAL_FIELDS));
        }

        return dtoJournals;
    }

    @Override
    public Journal getJournalById(long journalId) {

        Journals domainJournal = journalRepository.findByJournalIdAndEnabled(journalId, JOURNAL_IS_ENABLED);
        if (domainJournal == null) throw new JournalNotFoundException(journalId);
        else
            return PopulateJournalFromDomain.valueOf(domainJournal, INCLUDE_ALL_JOURNAL_FIELDS);
    }
}
