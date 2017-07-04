package com.ojs.service.content.v1.domain;


import org.springframework.data.repository.Repository;

import java.util.List;

public interface JournalRepository extends Repository<Journals, Long> {

    List<Journals> findByEnabled(boolean enabled);


    Journals findByJournalIdAndEnabled(long journalId, boolean enabled);
}
