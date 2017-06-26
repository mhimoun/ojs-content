package com.ojs.service.content.v1.controller;

import com.ojs.service.content.v1.dto.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleController {


    @GetMapping("/v1/article")
    public Article environments() {

        return new Article(1, 10, 2);


    }

}
