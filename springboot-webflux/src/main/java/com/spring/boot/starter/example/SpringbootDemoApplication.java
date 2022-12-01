package com.spring.boot.starter.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootDemoApplication.class);
//        springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
        springApplication.run(args);
    }

}
