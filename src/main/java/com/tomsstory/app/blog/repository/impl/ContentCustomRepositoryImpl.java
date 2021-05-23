package com.tomsstory.app.blog.repository.impl;

import com.tomsstory.app.blog.repository.ContentCustomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
@Slf4j
@AllArgsConstructor
public class ContentCustomRepositoryImpl implements ContentCustomRepository {

    final private EntityManager entityManager;


}
