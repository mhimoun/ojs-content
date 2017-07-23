package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.dto.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getPublishedArticles();

    Article getArticleById(long articleId);


}
