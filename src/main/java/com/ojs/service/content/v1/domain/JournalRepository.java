package com.ojs.service.content.v1.domain;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface JournalRepository extends Repository<Journals, Long> {

    List<Journals> findByEnabled(boolean enabled);


    @Query("Select j from Journals as j where j.journalId = ?1 and j.enabled = 1")
    Journals findByJournalId(long journalId);
}
