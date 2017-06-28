package com.ojs.service.content.v1.domain;


import org.springframework.data.repository.Repository;

import java.util.List;

public interface JournalRepository extends Repository<Journals, Long> {

    List<Journals> findByEnabled(int enabled);


}
