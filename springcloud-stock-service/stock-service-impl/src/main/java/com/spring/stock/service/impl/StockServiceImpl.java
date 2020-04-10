package com.spring.stock.service.impl;

import com.spring.stock.dto.Stock;
import org.apache.commons.lang.math.RandomUtils;
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


    private final static HashMap<Long, Stock> stocks = new HashMap<>();

    public void reduceStock(Stock stock) {
        System.out.println("订单：" + stock.getOrderId() + ",sku：" + stock.getSkuId() + ",减库存：" + stock.getNum());
        stocks.put(RandomUtils.nextLong(), stock);
    }


}
