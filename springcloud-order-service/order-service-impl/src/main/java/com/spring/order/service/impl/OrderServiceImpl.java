package com.spring.order.service.impl;

import com.spring.order.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 订单服务
 *
 * @author chenhao26
 * @version 1.0
 * @date 2020/4/9 18:18
 **/
@Service
public class OrderServiceImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    private final static HashMap<Long, Order> orders = new HashMap<>();

    public void pay(Order order) {
        orders.put(order.getId(), order);
        logger.info("订单ID:{}，购买：{}个，单价：{}，付款：{}，成功！", order.getId(), order.getNum(), order.getPrice(), order.getTotalPrice());
    }


    public Order getOrderById(Long orderId) {
        return orders.get(orderId);
    }

}
