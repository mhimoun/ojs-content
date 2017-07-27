package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Article;
import com.ojs.service.content.v1.exception.ArticleNotFoundException;
import com.ojs.service.content.v1.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/v1/article/{articleId}")
    public Article getArticleDefault(@PathVariable long articleId) {

        Article article = articleService.getArticleById(articleId);
        populateArticleHateoasLinks(article);
        return article;
    }

    private void populateArticleHateoasLinks(Article article) {

        Link selfLink = linkTo(methodOn(ArticleController.class).getArticleDefault(article.getArticleId())).withSelfRel();
        Link issueLink = linkTo(methodOn(IssueController.class).getIssueDefault(article.getIssueId())).withRel("issue");

        article.add(selfLink);
        article.add(issueLink);


    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleVinNotFound(ArticleNotFoundException ex) {
    }


}
