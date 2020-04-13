package com.spring.stock.service;

import com.spring.stock.dto.Stock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName StockApi
 * @Description 库存服务
 * @Author kider
 * @Date 2020/3/27 16:55
 * @Version 1.0
 **/
@FeignClient("stock-service")
@Api(tags = "库存服务接口")
public interface StockApi {

    @PostMapping("/stock/reduce")
    @ApiOperation("减库存接口")
    @ApiImplicitParam(name = "stock", value = "库存信息",required = true,dataTypeClass = Stock.class)
    String reduceStock(@RequestBody Stock stock);

}
