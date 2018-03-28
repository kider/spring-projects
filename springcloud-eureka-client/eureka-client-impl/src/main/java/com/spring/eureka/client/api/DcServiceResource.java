package com.spring.eureka.client.api;

import com.spring.eureka.client.service.DcService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

//@Api
//@ApiIgnore
//@RestController
@Controller
public class DcServiceResource implements DcService{

    @Autowired
    DiscoveryClient discoveryClient;

    @Override
    @ApiOperation("获取服务")
    @ResponseBody
    public String findService() {

        String services = "Services66: " + discoveryClient.getServices();
        System.out.println(services);
        return services;

    }
}
