package com.spring.stock.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName StockService
 * @Description 库存服务
 * @Author kider
 * @Date 2020/3/27 16:55
 * @Version 1.0
 **/
@FeignClient("stock-service")
@Api(tags = "库存服务接口")
public interface StockService {

    @PostMapping("/stock/reduce")
    @ApiOperation("减库存接口")
    @ApiImplicitParam(name = "num", value = "数量", defaultValue = "0", required = true, paramType = "query", dataType = "int")
    String reduceStock(@RequestParam(name = "num") Integer num);

}
