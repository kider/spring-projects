package com.spring.stock.controller;

import com.spring.stock.dto.Stock;
import com.spring.stock.service.StockApi;
import com.spring.stock.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StockServiceImpl stockService;

    @Override
    public String reduceStock(Stock stock) {
        stockService.reduceStock(stock);
        return "success";
    }
}
