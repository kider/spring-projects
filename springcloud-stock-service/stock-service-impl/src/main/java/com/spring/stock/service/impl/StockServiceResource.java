package com.spring.stock.service.impl;

import com.spring.stock.service.StockService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName StockServiceResource
 * @Description 库存服务
 * @Author kider
 * @Date 2020/3/27 17:01
 * @Version 1.0
 **/
@RestController
public class StockServiceResource implements StockService {

    @Override
    public String reduceStock(Integer num) {
        System.out.println("扣减库存:" + num);
        return "success";
    }
}
