package com.spring.order.mq;

import com.spring.order.dto.Order;
import com.spring.stock.dto.Stock;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

/**
 * @ClassName OrderMessageService
 * @Description 订单消息服务
 * @Author kider
 * @Date 2020/3/30 16:57
 * @Version 1.0
 **/
@Component
public class OrderMessageService {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @Value("${order.rocketmq.topic}")
    private String orderTopic;


    public void sendMsg(String msg) {
        // Send string
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, msg);
    }

    public void sendMsg(Stock stock) {
        //send Object
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, stock);
    }

    public void sendJSON(Stock stock) {
        //send json
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, MessageBuilder.withPayload(stock).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build());
    }

    public void sendSpringMsg(String msg) {
        // Send string with spring Message
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, MessageBuilder.withPayload(msg).build());
    }

    public void sendTransMsg(Stock stock, Order order) {
        // Send string with Transaction Message
        TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction(orderTopic, MessageBuilder.withPayload(stock).build(), order);
    }

}
