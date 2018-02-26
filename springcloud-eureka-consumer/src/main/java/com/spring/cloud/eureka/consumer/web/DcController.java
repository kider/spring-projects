package com.spring.cloud.eureka.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RestTemplate loadBalancedRestTemplate;
    @Autowired
    DcClient dcClient;


    @GetMapping("/consumer")
    public String consumer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/loadBalancedConsumer")
    public String loadBalancedConsumer() {
        return loadBalancedRestTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    @GetMapping("/feignConsumer")
    public String feignConsumer() {
        return dcClient.consumer();
    }


}
