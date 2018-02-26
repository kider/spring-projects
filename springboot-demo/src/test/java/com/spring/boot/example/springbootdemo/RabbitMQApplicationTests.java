package com.spring.boot.example.springbootdemo;

import com.spring.boot.example.springbootdemo.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class RabbitMQApplicationTests {



	@Autowired
	private Sender sender;

	@Test
	public void hello() throws Exception {
		sender.send();
	}



}
