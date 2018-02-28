package com.spring.cloud.eureka.consumer.service;

public interface ConsumerService {

    String consumer();


    String loadBalancedConsumer();


    String feignConsumer();
}
