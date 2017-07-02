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


    private JournalRepository journalRepository;

    @Autowired
    public DBJournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }


    @Override
    public List<Journal> getEnabledJournals() {

        List<Journal> dtoJournals = new ArrayList<>();

        List<Journals> domainJournals = journalRepository.findByEnabled(true);

        for (Journals dj : domainJournals) {
            dtoJournals.add(PopulateJournalFromDomain.valueOf(dj));
        }

        return dtoJournals;
    }

    @Override
    public Journal getJournalById(long journalId) {

        Journals domainJournal = journalRepository.findByJournalId(journalId);
        if (domainJournal == null) throw new JournalNotFoundException(journalId);
        else
            return PopulateJournalFromDomain.valueOf(domainJournal);
    }
}
