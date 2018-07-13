package com.spring.boot.example;

import com.spring.boot.example.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class AutoConfigurationApplicationTests {


	@Autowired
	private HelloService helloService;



	@Test
	public void testSay() throws Exception {

		helloService.say();

	}


}
