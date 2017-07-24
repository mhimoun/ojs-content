package com.ojs.service.content.v1.domain;


import org.springframework.data.repository.Repository;

import java.util.List;

public interface ArticleRepository extends Repository<Submissions, Long> {

    short ARTICLE_STATUS_PUBLISHED = 3;

    List<Submissions> findByStatus(short status);

    Submissions findBySubmissionIdAndStatus(long submissionId,short status);
}
