package com.spring.boot.starter.example.service;

import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    @Transactional
    void create(Long uid, Integer amount);

    @Transactional
    void deleteByUid(Long uid);

}
