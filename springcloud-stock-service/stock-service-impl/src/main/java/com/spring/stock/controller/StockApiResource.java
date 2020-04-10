package com.spring.stock.controller;

import com.spring.stock.service.StockApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName StockApiResource
 * @Description 库存服务
 * @Author kider
 * @Date 2020/3/27 17:01
 * @Version 1.0
 **/
@RestController
public class StockApiResource implements StockApi {

    @Override
    public String reduceStock(Integer num) {
        System.out.println("扣减库存:" + num);
        return "success";
    }
}
