package com.ojs.service.content.v1.service;


import com.ojs.service.content.v1.domain.ArticleRepository;
import com.ojs.service.content.v1.domain.Submissions;
import com.ojs.service.content.v1.dto.Article;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.ojs.service.content.v1.domain.ArticleRepository.ARTICLE_STATUS_PUBLISHED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DBArticleServiceTest {

    ArticleService articleService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private ArticleRepository articleRepository;

    @Before
    public void setup() {
        articleService = new DBArticleService(articleRepository);
    }

    @Test
    public void getPublishedArticles_shouldReturnEmptyListWhenNoPublishedArticles() throws Exception {

        List<Article> articles = articleService.getPublishedArticles();

        assertThat(articles.size()).isEqualTo(0);
        verify(articleRepository).findByStatus(ARTICLE_STATUS_PUBLISHED );

    }


    @Test
    public void getPublishedArticles_shouldReturnResultsWhenSubmissionsPublishedInDB() throws Exception {

        when(articleRepository.findByStatus(ARTICLE_STATUS_PUBLISHED)).thenReturn(submissions());
        List<Article> articles = articleService.getPublishedArticles();

        assertThat(articles.size()).isEqualTo(2);
    }



    private List<Submissions> submissions() {

        Submissions submissions = new Submissions();
        Submissions submissions2 = new Submissions();
        return Arrays.asList(submissions,submissions2);
    }

}
