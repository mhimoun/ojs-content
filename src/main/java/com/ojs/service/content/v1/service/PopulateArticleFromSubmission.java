package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.SubmissionSettings;
import com.ojs.service.content.v1.domain.Submissions;
import com.ojs.service.content.v1.dto.Article;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;


public class PopulateArticleFromSubmission {

    public static Article valueOf(Submissions submission, boolean includeAllDetails) {

        Article article = new Article(submission.getSubmissionId(), submission.getPublishedSubmission().getIssueId(), 0);
        article.setPages(submission.getPages());
        article.setDatePublished(submission.getPublishedSubmission().getDatePublished());

        if (submission.getSubmissionSettings() != null) {
            Map<String, SubmissionSettings> settingsMap = submission.getSubmissionSettings().stream().collect(toMap(SubmissionSettings::getSettingName, Function.identity()));
           if (settingsMap.get("title")!=null)  article.setTitle(settingsMap.get("title").getSettingValue());
            if (settingsMap.get("subtitle")!=null)    article.setSubTitle(settingsMap.get("subtitle").getSettingValue());
            if (settingsMap.get("prefix")!=null)     article.setPrefix(settingsMap.get("prefix").getSettingValue());

            if (includeAllDetails){
                if (settingsMap.get("cleanTitle")!=null) article.setCleanTitle(settingsMap.get("cleanTitle").getSettingValue());
                if (settingsMap.get("copyrightYear")!=null)   article.setCopyrightYear(settingsMap.get("copyrightYear").getSettingValue());
                if (settingsMap.get("abstract")!=null)    article.setArticleAbstract(settingsMap.get("abstract").getSettingValue());
                if (settingsMap.get("coverage")!=null)     article.setCoverage(settingsMap.get("coverage").getSettingValue());
                if (settingsMap.get("copyrightHolder")!=null)     article.setCopyrightHolder(settingsMap.get("copyrightHolder").getSettingValue());
            }

            }


        return article;
    }
}
