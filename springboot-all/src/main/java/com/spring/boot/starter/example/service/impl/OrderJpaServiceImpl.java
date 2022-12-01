package com.spring.boot.starter.example.service.impl;

import com.spring.boot.starter.example.entity.Order;
import com.spring.boot.starter.example.service.OrderRepository;
import com.spring.boot.starter.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service(value = "orderJpaService")
public class OrderJpaServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void create(Long uid, Integer amount) {
        Order u = new Order(uid, amount);
        orderRepository.save(u);
    }

    @Override
    public void deleteByUid(Long uid) {
        List<Order> orders = orderRepository.findByUserId(uid);
        if (!CollectionUtils.isEmpty(orders)) {
            for (Order o : orders) {
                orderRepository.delete(o);
            }
        }
    }
}