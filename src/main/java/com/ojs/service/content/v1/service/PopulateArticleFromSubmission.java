package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.SubmissionSettings;
import com.ojs.service.content.v1.domain.Submissions;
import com.ojs.service.content.v1.dto.Article;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;


public class PopulateArticleFromSubmission {

    public static Article valueOf(Submissions submission) {

        Article article = new Article(submission.getSubmissionId(), submission.getPublishedSubmission().getIssueId(), 0);
        article.setPages(submission.getPages());
        article.setDatePublished(submission.getPublishedSubmission().getDatePublished());

        if (submission.getSubmissionSettings() != null) {
            Map<String, SubmissionSettings> settingsMap = submission.getSubmissionSettings().stream().collect(toMap(SubmissionSettings::getSettingName, Function.identity()));
            article.setTitle(settingsMap.get("title").getSettingValue());
            article.setCleanTitle(settingsMap.get("cleanTitle").getSettingValue());
            article.setSubTitle(settingsMap.get("subtitle").getSettingValue());
            article.setCopyrightYear(settingsMap.get("copyrightYear").getSettingValue());
            article.setArticleAbstract(settingsMap.get("abstract").getSettingValue());
            article.setPrefix(settingsMap.get("prefix").getSettingValue());
            article.setCoverage(settingsMap.get("coverage").getSettingValue());
            article.setCopyrightHolder(settingsMap.get("copyrightHolder").getSettingValue());
        }
        return article;
    }
}
