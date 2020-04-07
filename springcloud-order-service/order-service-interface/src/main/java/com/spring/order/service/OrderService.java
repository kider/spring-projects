package com.spring.order.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName OrderService
 * @Description 订单服务接口
 * @Author kider
 * @Date 2020/3/26 17:47
 * @Version 1.0
 **/
@FeignClient("order-service")
@Api(tags = "订单服务接口")
public interface OrderService {

    @PostMapping("/order/buy")
    @ApiOperation("下单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "数量", defaultValue = "1", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name = "price", value = "价格", defaultValue = "100.00", required = true, paramType = "form", dataType = "double")
    })
    String buy(@RequestParam(name = "num") Integer num,@RequestParam(name = "price") Double price);

}