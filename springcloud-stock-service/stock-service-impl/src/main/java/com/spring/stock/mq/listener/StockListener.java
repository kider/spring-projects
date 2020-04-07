package com.spring.stock.mq.listener;

import com.alibaba.fastjson.JSONObject;
import com.spring.stock.dto.Stock;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName StockListener
 * @Description 库存MQ Listener
 * @Author kider
 * @Date 2020/4/1 15:13
 * @Version 1.0
 **/
@Service
@RocketMQMessageListener(topic = "${order.rocketmq.topic}", consumerGroup = "stock_consumer", selectorExpression = "${stock.rocketmq.tag}")
public class StockListener implements RocketMQListener<Stock> {


    @Override
    public void onMessage(Stock stock) {
        System.out.println("通过Mq扣减库存:" + JSONObject.toJSONString(stock));
    }
}
