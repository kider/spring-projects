package com.spring.stock.mq.listener;

import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import com.spring.stock.dto.Stock;
import com.spring.stock.service.impl.StockServiceImpl;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName StockListener
 * @Description 库存MQ Listener
 * @Author kider
 * @Date 2020/4/1 15:13
 * @Version 1.0
 **/
@Service
@RocketMQMessageListener(topic = "${order.rocketmq.topic}", consumerGroup = "stock_consumer")
public class StockListener implements RocketMQListener<Stock> {

    @Autowired
    private StockServiceImpl stockService;

    @Override
    public void onMessage(Stock stock) {
        stockService.reduceStock(stock);
    }
}
