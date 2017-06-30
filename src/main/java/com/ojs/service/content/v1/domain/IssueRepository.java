package com.ojs.service.content.v1.domain;


import org.springframework.data.repository.Repository;

import java.util.List;

public interface IssueRepository extends Repository<Issues, Long> {

    List<Issues> findByPublished(boolean published);


}
