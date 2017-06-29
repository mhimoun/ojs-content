package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;


public class PopulateJournalFromDomain {
    public static Journal valueOf(Journals journalDomain) {
        Journal journal = new Journal(journalDomain.getJournalId(), journalDomain.getPath());
        journal.setPrimaryLocale(journalDomain.getPrimaryLocale());
        return journal;
    }
}
