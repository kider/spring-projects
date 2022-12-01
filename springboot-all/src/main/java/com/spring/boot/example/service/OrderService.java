package com.spring.boot.example.service;

import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    @Transactional
    void create(Long uid, Integer amount);

    @Transactional
    void deleteByUid(Long uid);

}
