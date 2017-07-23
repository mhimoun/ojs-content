package com.ojs.service.content.v1.service;

import com.ojs.service.content.v1.domain.ArticleRepository;
import com.ojs.service.content.v1.domain.Submissions;
import com.ojs.service.content.v1.dto.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBArticleService implements ArticleService {

    @Autowired
    private final ArticleRepository articleRepository;

    public DBArticleService(ArticleRepository articleRepository) {
        this.articleRepository= articleRepository;
    }

    @Override
    public List<Article> getPublishedArticles() {

        List<Article> articles = new ArrayList<>();
        List<Submissions> publishedSubmissions = articleRepository.findByStatus((short) 3);

        for (Submissions submissions: publishedSubmissions){
            articles.add(new Article(1,1,1));
        }
        return articles;
    }

    @Override
    public Article getArticleById(long articleId) {
        return null;
    }
}
