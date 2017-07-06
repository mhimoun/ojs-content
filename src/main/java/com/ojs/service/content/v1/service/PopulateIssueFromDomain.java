package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.IssueSettings;
import com.ojs.service.content.v1.domain.Issues;
import com.ojs.service.content.v1.domain.JournalSettings;
import com.ojs.service.content.v1.dto.Issue;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class PopulateIssueFromDomain {
    public static Issue valueOf(Issues issuesDomain) {

        Issue issue = new Issue();
        BeanUtils.copyProperties(issuesDomain, issue);


        if (!CollectionUtils.isEmpty(issuesDomain.getIssueSettings())) {
            Map<String, IssueSettings> settingsMap = issuesDomain.getIssueSettings().stream().collect(toMap(IssueSettings::getSettingName, Function.identity()));
            if (settingsMap.containsKey("description")) issue.setDescription(settingsMap.get("description").getSettingValue());
            if (settingsMap.containsKey("title")) issue.setTitle(settingsMap.get("title").getSettingValue());
            if (settingsMap.containsKey("coverImageAltText")) issue.setCoverImageAltText(settingsMap.get("coverImageAltText").getSettingValue());
            if (settingsMap.containsKey("coverImage")) issue.setCoverImage(settingsMap.get("coverImage").getSettingValue());
            if (settingsMap.containsKey("pub-id::publisher-id")) issue.setPublisherId(settingsMap.get("pub-id::publisher-id").getSettingValue());
        }
        return issue;
    }
}
