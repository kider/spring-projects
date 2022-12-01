package com.spring.boot.starter.example;

import com.spring.boot.starter.example.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class UserJdbcServiceApplicationTests {

	@Autowired
	private UserService userJdbcService;

	@Before
	public void setUp() {
		// 准备，清空user表
		userJdbcService.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		int i = 10;
		// 插入10个用户
		userJdbcService.createBath(i);

		// 查数据库，应该有10个用户
		Assert.assertEquals(i, userJdbcService.getAllUsers().intValue());

		// 删除两个用户
		userJdbcService.deleteByName("name1");
		userJdbcService.deleteByName("name2");

		// 查数据库，应该有i-2个用户
		Assert.assertEquals(i-2, userJdbcService.getAllUsers().intValue());

	}



}
