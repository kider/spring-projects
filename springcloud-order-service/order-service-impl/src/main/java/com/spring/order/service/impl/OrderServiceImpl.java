package com.spring.order.service.impl;

import com.spring.order.dto.Order;
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

    private final static HashMap<Long, Order> orders = new HashMap<>();

    public void pay(Order order) {
        orders.put(order.getId(), order);
        System.out.println("订单ID:" + order.getId() + "，购买" + order.getNum() + "个，单价：" + order.getPrice() + "，付款:" + order.getTotalPrice() + "成功！");
    }


    public Order getOrderById(Long orderId) {
        return orders.get(orderId);
    }

}
