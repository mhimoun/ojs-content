package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.JournalSettings;
import com.ojs.service.content.v1.domain.Journals;
import com.ojs.service.content.v1.dto.Journal;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PopulateJournalFromDomainTest {


    @Test
    public void shouldPopulateJournalIdAndPath() throws Exception {

        Journals journalDomain = new Journals(11l, "path1", "en-US");
        Journal journalDto = PopulateJournalFromDomain.valueOf(journalDomain);

        assertThat(journalDto.getJournalId()).isEqualTo(11l);
        assertThat(journalDto.getPath()).isEqualTo("path1");
    }


    @Test
    public void shouldPopulatePrimaryLocal() throws Exception {

        Journals journalDomain = new Journals(11l, "path1", "en-US");
        Journal journalDto = PopulateJournalFromDomain.valueOf(journalDomain);

        assertThat(journalDto.getPrimaryLocale()).isEqualTo("en-US");
    }


    @Test
    public void shouldPopulateDescription() throws Exception {

        Journals journalDomain = new Journals(1l, "path1", "en-US");
        JournalSettings description = new JournalSettings(1l, "en-US", "description", "my description", "string");
        List<JournalSettings> settings = Arrays.asList(description);
        journalDomain.setJournalSettings(settings);


        Journal journalDto = PopulateJournalFromDomain.valueOf(journalDomain);

        assertThat(journalDto.getDescription()).isEqualTo("my description");
    }

    @Test
    public void shouldPopulateOnlineIssn() throws Exception {

        Journals journalDomain = new Journals(1l, "path1", "en-US");
        JournalSettings onlineIssn = new JournalSettings(1l, "", "onlineIssn", "my onlineIssn", "string");
        List<JournalSettings> settings = Arrays.asList(onlineIssn);
        journalDomain.setJournalSettings(settings);


        Journal journalDto = PopulateJournalFromDomain.valueOf(journalDomain);

        assertThat(journalDto.getOnlineIssn()).isEqualTo("my onlineIssn");
    }

    @Test
    public void shouldPopulatePrintIssn() throws Exception {

        Journals journalDomain = new Journals(1l, "path1", "en-US");
        JournalSettings printIssn = new JournalSettings(1l, "", "printIssn", "my printIssn", "string");
        List<JournalSettings> settings = Arrays.asList(printIssn);
        journalDomain.setJournalSettings(settings);


        Journal journalDto = PopulateJournalFromDomain.valueOf(journalDomain);

        assertThat(journalDto.getPrintIssn()).isEqualTo("my printIssn");
    }

    @Test
    public void shouldPopulateAbbreviation() throws Exception {

        Journals journalDomain = new Journals(1l, "path1", "en-US");
        JournalSettings abbreviation = new JournalSettings(1l, "", "abbreviation", "some abbreviation", "string");
        List<JournalSettings> settings = Arrays.asList(abbreviation);
        journalDomain.setJournalSettings(settings);


        Journal journalDto = PopulateJournalFromDomain.valueOf(journalDomain);

        assertThat(journalDto.getAbbreviation()).isEqualTo("some abbreviation");
    }

    @Test
    public void shouldPopulateName() throws Exception {

        Journals journalDomain = new Journals(1l, "path1", "en-US");
        JournalSettings name = new JournalSettings(1l, "", "name", "some name", "string");
        List<JournalSettings> settings = Arrays.asList(name);
        journalDomain.setJournalSettings(settings);


        Journal journalDto = PopulateJournalFromDomain.valueOf(journalDomain);

        assertThat(journalDto.getName()).isEqualTo("some name");
    }

}
