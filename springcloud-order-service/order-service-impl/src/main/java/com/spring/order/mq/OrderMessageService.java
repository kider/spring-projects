package com.spring.order.mq;

import com.spring.order.dto.Order;
import com.spring.stock.dto.Stock;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.Resource;

/**
 * @ClassName OrderMessageService
 * @Description 订单消息服务
 * @Author kider
 * @Date 2020/3/30 16:57
 * @Version 1.0
 **/
//@Service
public class OrderMessageService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${order.rocketmq.topic}")
    private String orderTopic;

    @Resource(name = "orderExtRocketMQTemplate")
    private RocketMQTemplate orderExtRocketMQTemplate;


    public void sendMsg(String msg) {
        // Send string
        SendResult sendResult = orderExtRocketMQTemplate.syncSend(orderTopic, msg);
    }

    public void sendMsg(Stock stock) {
        //send Object
        SendResult sendResult = orderExtRocketMQTemplate.syncSend(orderTopic, stock);
    }

    public void sendJSON(Stock stock) {
        //send json
        SendResult sendResult = orderExtRocketMQTemplate.syncSend(orderTopic, MessageBuilder.withPayload(stock).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build());
    }

    public void sendSpringMsg(String msg) {
        // Send string with spring Message
        SendResult sendResult = orderExtRocketMQTemplate.syncSend(orderTopic, MessageBuilder.withPayload(msg).build());
    }

    public void sendTransMsg(Stock stock, Order order) {
        // Send string with Transaction Message
        TransactionSendResult sendResult = orderExtRocketMQTemplate.sendMessageInTransaction(orderTopic, MessageBuilder.withPayload(stock).build(), order);
    }

}
