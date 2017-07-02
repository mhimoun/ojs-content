package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.JournalSettings;
import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;


public class PopulateJournalFromDomain {
    public static Journal valueOf(Journals journalDomain) {
        Journal journal = new Journal(journalDomain.getJournalId(), journalDomain.getPath());
        journal.setPrimaryLocale(journalDomain.getPrimaryLocale());

        if (!CollectionUtils.isEmpty(journalDomain.getJournalSettings())) {
            Map<String, JournalSettings> settingsMap = journalDomain.getJournalSettings().stream().collect(toMap(JournalSettings::getSettingName, Function.identity()));

            if (settingsMap.containsKey("description")) journal.setDescription(settingsMap.get("description").getSettingValue());
            if (settingsMap.containsKey("onlineIssn")) journal.setOnlineIssn(settingsMap.get("onlineIssn").getSettingValue());
            if (settingsMap.containsKey("abbreviation")) journal.setAbbreviation(settingsMap.get("abbreviation").getSettingValue());
            if (settingsMap.containsKey("name")) journal.setName(settingsMap.get("name").getSettingValue());

        }

        return journal;
    }
}
