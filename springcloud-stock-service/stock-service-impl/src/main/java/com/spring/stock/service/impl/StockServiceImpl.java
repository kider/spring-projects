package com.spring.stock.service.impl;

import com.spring.stock.dto.Stock;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 库存服务
 *
 * @author chenhao26
 * @version 1.0
 * @date 2020/4/10 10:00
 **/
@Service
public class StockServiceImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static HashMap<Long, Stock> stocks = new HashMap<>();

    public void reduceStock(Stock stock) {
        logger.info("订单：{}，sku：{}，减库存：{}", stock.getOrderId(), stock.getSkuId(), stock.getNum());
        stocks.put(RandomUtils.nextLong(), stock);
    }


}
