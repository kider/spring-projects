package com.spring.boot.starter.example.configure;


import com.spring.boot.starter.example.properties.HelloProperties;
import com.spring.boot.starter.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
@AutoConfigureBefore(HelloAutoConfiguration.class)
public class WordAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    @Bean("wordService")
    public HelloService getHelloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg(helloProperties.getMsg());
        return helloService;
    }


}
