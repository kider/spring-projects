package com.spring.order.controller;

import com.spring.order.dto.Order;
import com.spring.order.mq.OrderMessageService;
import com.spring.order.service.OrderApi;
import com.spring.order.service.impl.OrderServiceImpl;
import com.spring.stock.dto.Stock;
import com.spring.stock.service.StockApi;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    private StockApi stockApi;

    @Autowired
    private OrderServiceImpl orderService;

   /* @Autowired
    private OrderMessageService orderMessageService;*/

    @Value("${order.rocketmq.topic}")
    private String orderTopic;

    @Resource(name = "orderExtRocketMQTemplate")
    private RocketMQTemplate orderExtRocketMQTemplate;

    @Override
    public String buyMQ(Integer num, Double price) {

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
        TransactionSendResult sendResult = orderExtRocketMQTemplate.sendMessageInTransaction(orderTopic, MessageBuilder.withPayload(stock).build(), order);
        return "success";
    }

    @Override
    public String buy(Order order) {
        Long id = RandomUtils.nextLong();
        order.setId(id);
        orderService.pay(order);
        Stock stock = new Stock();
        stock.setOrderId(id);
        stock.setSkuId(100001L);
        stock.setNum(order.getNum());
        stockApi.reduceStock(stock);
        return "success";
    }
}
