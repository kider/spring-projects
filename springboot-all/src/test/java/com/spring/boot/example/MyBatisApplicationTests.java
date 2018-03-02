package com.spring.boot.example;

import com.spring.boot.example.dto.UserDto;
import com.spring.boot.example.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class MyBatisApplicationTests {

	@Autowired
	private UserMapper userMapper;


	@Test
	@Rollback
	public void testMyBatis() throws Exception {
		userMapper.insert("chenhao",28);
		UserDto u = userMapper.findByName("chenhao");
		Assert.assertEquals(28, u.getAge().intValue());

	}

}
