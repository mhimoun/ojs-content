package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Article;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class ArticleController {


    @GetMapping("/v1/article/{articleId}")
    public Article getArticleDefault(@PathVariable int articleId) {

        Article article = new Article(1, 10, articleId);

        populateArticleHateoasLinks(article, articleId);
        return article;
    }

    private void populateArticleHateoasLinks(Article article, int articleId) {

        Link selfLink = linkTo(methodOn(ArticleController.class).getArticleDefault(articleId)).withSelfRel();
        Link journalLink = linkTo(methodOn(JournalController.class).getJournalDefault(1)).withRel("journal");

        article.add(selfLink);
        article.add(journalLink);


    }

}
