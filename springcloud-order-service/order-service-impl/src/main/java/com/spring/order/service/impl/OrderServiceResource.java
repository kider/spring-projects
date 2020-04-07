package com.spring.order.service.impl;

import com.spring.order.mq.OrderMessageService;
import com.spring.order.service.OrderService;
import com.spring.stock.dto.Stock;
import com.spring.stock.service.StockService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderServiceResource
 * @Description 订单服务
 * @Author kider
 * @Date 2020/3/26 16:33
 * @Version 1.0
 **/
@RestController
public class OrderServiceResource implements OrderService {

    @Autowired
    private StockService stockService;

    @Autowired
    private OrderMessageService orderMessageService;

    @Override
    public String buy(Integer num, Double price) {
        System.out.println("购买数量" + num + "，单价：" + price + "，总价：" + (num * price));
        System.out.println("开始扣减库存，发送MQ");
        //发送mq
        Stock stock = new Stock();
        stock.setOrderId(RandomUtils.nextLong());
        stock.setSkuId(100001L);
        stock.setNum(num);
        orderMessageService.sendMsg(stock);

//        String result = stockService.reduceStock(num);

        return "success";
    }
}
