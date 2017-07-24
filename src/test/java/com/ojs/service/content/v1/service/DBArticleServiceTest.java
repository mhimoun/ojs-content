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
import static org.mockito.Mockito.*;

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
        when(articleRepository.findByStatus(ARTICLE_STATUS_PUBLISHED)).thenReturn(submissions());
    }

    @Test
    public void getPublishedArticles_shouldReturnEmptyListWhenNoPublishedArticles() throws Exception {

        ArticleRepository repository = mock(ArticleRepository.class);
        articleService = new DBArticleService(repository);
        List<Article> articles = articleService.getPublishedArticles();

        assertThat(articles.size()).isEqualTo(0);
        verify(repository).findByStatus(ARTICLE_STATUS_PUBLISHED);

    }


    @Test
    public void getPublishedArticles_shouldReturnResultsWhenSubmissionsPublishedInDB() throws Exception {

        List<Article> articles = articleService.getPublishedArticles();
        assertThat(articles.size()).isEqualTo(2);
    }


    @Test
    public void getPublishedArticles_shouldReturnArticlesWithId() throws Exception {

        List<Article> articles = articleService.getPublishedArticles();
        assertThat(articles.get(0).getArticleId()).isEqualTo(11);
        assertThat(articles.get(1).getArticleId()).isEqualTo(13);
    }

    @Test
    public void getPublishedArticles_shouldReturnDatePublished() throws Exception {

        List<Article> articles = articleService.getPublishedArticles();
        assertThat(articles.get(0).getIssueId()).isEqualTo(3);
    }


    private List<Submissions> submissions() {

        Submissions submissions = new Submissions(11);
        submissions.getPublishedSubmission().setIssueId(3);
        Submissions submissions2 = new Submissions(13);
        return Arrays.asList(submissions, submissions2);
    }

}
