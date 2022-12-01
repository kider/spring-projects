package com.spring.boot.starter.example.service.impl;

import com.spring.boot.starter.example.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service(value = "orderJdbcService")
public class OrderJdbcServiceImpl implements OrderService {

    Logger logger = LoggerFactory.getLogger(OrderJdbcServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(Long uid, Integer amount) {
        logger.debug("create t_order uid:{},amount:{}", uid, amount);
        jdbcTemplate.update("insert into t_order(uid, amount) values(?, ?)", uid, amount);
    }

    @Override
    public void deleteByUid(Long uid) {
        logger.debug("delete t_order uid:{}", uid);
        jdbcTemplate.update("delete from t_order where uid = ?", uid);
    }
}
