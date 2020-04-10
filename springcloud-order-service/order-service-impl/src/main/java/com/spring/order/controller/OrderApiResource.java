package com.spring.order.controller;

import com.spring.order.dto.Order;
import com.spring.order.mq.OrderMessageService;
import com.spring.order.service.OrderApi;
import com.spring.stock.dto.Stock;
import com.spring.stock.service.StockApi;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderApiResource
 * @Description 订单服务
 * @Author kider
 * @Date 2020/3/26 16:33
 * @Version 1.0
 **/
@RestController
public class OrderApiResource implements OrderApi {

    @Autowired
    private StockApi stockService;

    @Autowired
    private OrderMessageService orderMessageService;

    @Override
    public String buy(Integer num, Double price) {

        Long id = RandomUtils.nextLong();
        Order order = new Order();
        order.setId(id);
        order.setNum(num);
        order.setPrice(price);
        order.setTotalPrice(num * price);

        //发送事务消息
        Stock stock = new Stock();
        stock.setOrderId(id);
        stock.setSkuId(100001L);
        stock.setNum(num);
        orderMessageService.sendTransMsg(stock, order);

        return "success";
    }
}
