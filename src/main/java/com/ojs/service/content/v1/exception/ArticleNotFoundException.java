package com.ojs.service.content.v1.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(long articleId) {
        super("Article does not exist or not publsihed for ID " + articleId);
    }
}
