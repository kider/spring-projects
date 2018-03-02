package com.spring.cloud.config.client.web;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class ConfigController {

    @Value("${info.profile}")
    private String profile;


    @RequestMapping("/profile")
    public String configProfile() {
        return this.profile;
    }

}
