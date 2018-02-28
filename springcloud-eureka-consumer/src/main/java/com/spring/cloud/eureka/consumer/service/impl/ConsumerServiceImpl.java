package com.spring.cloud.eureka.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.eureka.consumer.service.ConsumerService;
import com.spring.cloud.eureka.consumer.web.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerServiceImpl implements ConsumerService{

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RestTemplate loadBalancedRestTemplate;
    @Autowired
    DcClient dcClient;

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public String loadBalancedConsumer() {
        return loadBalancedRestTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public String feignConsumer() {
        return dcClient.consumer();
    }

    public String fallback() {
        return "fallback";
    }

}
