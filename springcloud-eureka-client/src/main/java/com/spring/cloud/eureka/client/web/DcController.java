package com.spring.cloud.eureka.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        //为了演示 Hystrix 服务降级 加上以下代码
//        Thread.sleep(5000L); //超时
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
