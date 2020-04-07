package com.spring.order.mq;

import com.spring.stock.dto.Stock;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
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


    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @Value("${order.rocketmq.topic}")
    private String orderTopic;


    public void sendMsg(String msg) {
        // Send string
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, msg);
        System.out.printf("sendMsg to topic %s sendResult=%s %n", orderTopic, sendResult);
    }

    public void sendMsg(Stock stock) {
        //send Object
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, stock);
        System.out.printf("sendMsg to topic %s sendResult=%s %n", orderTopic, sendResult);
    }

    public void sendJSON(Stock stock) {
        //send json
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, MessageBuilder.withPayload(stock).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build());
        System.out.printf("sendJSON to topic %s sendResult=%s %n", orderTopic, sendResult);
    }

    public void sendSpringMsg(String msg) {
        // Send string with spring Message
        SendResult sendResult = rocketMQTemplate.syncSend(orderTopic, MessageBuilder.withPayload(msg).build());
        System.out.printf("sendSpringMsg to topic %s sendResult=%s %n", orderTopic, sendResult);

    }

}
