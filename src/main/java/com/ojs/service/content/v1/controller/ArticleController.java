package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Article;
import com.ojs.service.content.v1.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/v1/article/{articleId}")
    public Article getArticleDefault(@PathVariable long articleId) {

        Article article =articleService.getArticleById(articleId);
        populateArticleHateoasLinks(article);
        return article;
    }

    private void populateArticleHateoasLinks(Article article) {

        Link selfLink = linkTo(methodOn(ArticleController.class).getArticleDefault(article.getArticleId())).withSelfRel();
        Link issueLink = linkTo(methodOn(IssueController.class).getIssueDefault(10)).withRel("issue");
        Link journalLink = linkTo(methodOn(JournalController.class).getJournalDefault(1)).withRel("journal");

        article.add(selfLink);
        article.add(issueLink);
        article.add(journalLink);


    }

}
