package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.dto.Journal;

import java.util.List;



public interface JournalService {


    List<Journal> getEnabledJournals();


}
