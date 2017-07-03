package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.JournalSettings;
import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;


public class PopulateJournalFromDomain {

    public static Journal valueOf(Journals journalDomain, boolean includeAllSettings) {
        Journal journal = new Journal(journalDomain.getJournalId(), journalDomain.getPath());
        journal.setPrimaryLocale(journalDomain.getPrimaryLocale());

        if (!CollectionUtils.isEmpty(journalDomain.getJournalSettings())) {
            Map<String, JournalSettings> settingsMap = journalDomain.getJournalSettings().stream().collect(toMap(JournalSettings::getSettingName, Function.identity()));

            if (settingsMap.containsKey("searchDescription")) journal.setSearchDescription(settingsMap.get("searchDescription").getSettingValue());
            if (settingsMap.containsKey("abbreviation")) journal.setAbbreviation(settingsMap.get("abbreviation").getSettingValue());
            if (settingsMap.containsKey("name")) journal.setName(settingsMap.get("name").getSettingValue());

            if(includeAllSettings) {
                if (settingsMap.containsKey("description"))
                    journal.setDescription(settingsMap.get("description").getSettingValue());
                if (settingsMap.containsKey("onlineIssn"))
                    journal.setOnlineIssn(settingsMap.get("onlineIssn").getSettingValue());
                if (settingsMap.containsKey("printIssn"))
                    journal.setPrintIssn(settingsMap.get("printIssn").getSettingValue());
                if (settingsMap.containsKey("contactName"))
                    journal.setContactName(settingsMap.get("contactName").getSettingValue());
                if (settingsMap.containsKey("contactEmail"))
                    journal.setContactEmail(settingsMap.get("contactEmail").getSettingValue());
                if (settingsMap.containsKey("contactPhone"))
                    journal.setContactPhone(settingsMap.get("contactPhone").getSettingValue());
                if (settingsMap.containsKey("contactAffiliation"))
                    journal.setContactAffiliation(settingsMap.get("contactAffiliation").getSettingValue());
                if (settingsMap.containsKey("contactTitle"))
                    journal.setContactTitle(settingsMap.get("contactTitle").getSettingValue());
            }
        }

        return journal;
    }
}
