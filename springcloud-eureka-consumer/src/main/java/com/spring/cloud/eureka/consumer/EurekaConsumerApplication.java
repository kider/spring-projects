package com.spring.cloud.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableHystrix
@EnableCircuitBreaker
public class EurekaConsumerApplication {

	@Bean(name = "restTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean(name = "loadBalancedRestTemplate")
	@LoadBalanced
	public RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
