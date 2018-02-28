package com.spring.cloud.eureka.consumer.web;

import com.spring.cloud.eureka.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    private ConsumerService consumerService;


    @GetMapping("/consumer")
    public String consumer() {
        return consumerService.consumer();
    }


    @GetMapping("/loadBalancedConsumer")
    public String loadBalancedConsumer() {
        return consumerService.loadBalancedConsumer();
    }

    @GetMapping("/feignConsumer")
    public String feignConsumer() {
        return consumerService.feignConsumer();
    }


}
