package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.SubmissionSettings;
import com.ojs.service.content.v1.domain.Submissions;
import com.ojs.service.content.v1.dto.Article;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PopulateArticleFromSubmissionTest {


    @Test
    public void valueOf_shouldReturnArticleWithArticleId() throws Exception {

        Article article = PopulateArticleFromSubmission.valueOf(new Submissions(5), false);

        assertThat(article.getArticleId()).isEqualTo(5);

    }

    @Test
    public void valueOf_shouldReturnArticleWithIssueId() throws Exception {

        Article article = PopulateArticleFromSubmission.valueOf(getSubmission(), false);

        assertThat(article.getIssueId()).isEqualTo(3);

    }

    @Test
    public void valueOf_shouldReturnArticleWitDatePublished() throws Exception {
        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-06-29 15:18:00");

        Article article = PopulateArticleFromSubmission.valueOf(getSubmission(), false);

        assertThat(article.getDatePublished()).hasSameTimeAs(expectedDate);

    }


    @Test
    public void valueOf_shouldReturnArticleWithPages() throws Exception {

        Article article = PopulateArticleFromSubmission.valueOf(getSubmission(), false);

        assertThat(article.getPages()).isEqualTo("some pages");

    }

    @Test
    public void valueOf_shouldReturnArticleSettings() throws Exception {

        Article article = PopulateArticleFromSubmission.valueOf((getSubmission()), true);
        assertThat(article.getTitle()).isEqualTo("some title");
        assertThat(article.getSubTitle()).isEqualTo("sub title");
        assertThat(article.getCleanTitle()).isEqualTo("some clean title");
        assertThat(article.getCopyrightYear()).isEqualTo("2017");
        assertThat(article.getArticleAbstract()).isEqualTo("some abstract");
        assertThat(article.getPrefix()).isEqualTo("some prefix");
        assertThat(article.getCoverage()).isEqualTo("some coverage");
        assertThat(article.getCopyrightHolder()).isEqualTo("some copyrightHolder");

    }

    @Test
    public void valueOf_shouldPopulateMainSettingsIfIncludeAllDetailsIsFalse() throws Exception {

        Article article = PopulateArticleFromSubmission.valueOf((getSubmission()), false);
        assertThat(article.getTitle()).isEqualTo("some title");
        assertThat(article.getSubTitle()).isEqualTo("sub title");
        assertThat(article.getPrefix()).isEqualTo("some prefix");

    }


     @Test
    public void valueOf_shouldNotPopulateFieldsIfIncludeAllSettingIfFalse() throws Exception {

        Article article = PopulateArticleFromSubmission.valueOf((getSubmission()),false);
        assertThat(article.getCleanTitle()).isNull();
        assertThat(article.getArticleAbstract()).isNull();
        assertThat(article.getCopyrightHolder()).isNull();

    }

    private Submissions getSubmission() throws ParseException {
        Date datePublished = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2017-06-29 15:18:00");

        Submissions submissions = new Submissions(11);
        submissions.setPages("some pages");
        submissions.getPublishedSubmission().setIssueId(3);
        submissions.getPublishedSubmission().setDatePublished(datePublished);

        SubmissionSettings title = new SubmissionSettings(11, "en", "title", "some title", "string");
        SubmissionSettings cleanTitle = new SubmissionSettings(11, "en", "cleanTitle", "some clean title", "string");
        SubmissionSettings subTitle = new SubmissionSettings(11, "en", "subtitle", "sub title", "string");
        SubmissionSettings copyrightYear = new SubmissionSettings(11, "", "copyrightYear", "2017", "string");
        SubmissionSettings articleAbstract = new SubmissionSettings(11, "", "abstract", "some abstract", "string");
        SubmissionSettings coverage = new SubmissionSettings(11, "", "coverage", "some coverage", "string");
        SubmissionSettings prefix = new SubmissionSettings(11, "", "prefix", "some prefix", "string");
        SubmissionSettings copyrightHolder = new SubmissionSettings(11, "", "copyrightHolder", "some copyrightHolder", "string");
        List<SubmissionSettings> settings = Arrays.asList(title, subTitle, cleanTitle, copyrightYear, articleAbstract, copyrightHolder, prefix, coverage);
        submissions.setSubmissionSettings(settings);

        return submissions;
    }

}