package com.spring.boot.starter.example;

import com.spring.boot.starter.example.webflux.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * 测试webflux
 *
 * @author chenhao-ds6
 * @version 1.0
 * @date 2019/4/12 14:55
 **/
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = HelloController.class)
public class WebFluxApplicationTests {

    @Autowired
    WebTestClient client;

    @Test
    public void getHello() {
        client.get().uri("http://localhost:8989/hello").exchange().expectStatus().isOk();
    }

}
