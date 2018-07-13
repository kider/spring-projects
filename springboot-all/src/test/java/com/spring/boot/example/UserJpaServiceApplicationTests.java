package com.spring.boot.example;

import com.spring.boot.example.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class UserJpaServiceApplicationTests {

	@Autowired
	@Qualifier("userJpaService")
	private UserService userJpaService1;

	@Before
	public void setUp() {
		// 准备，清空user表
		userJpaService1.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {

		int i = 9;

		userJpaService1.createBath(i);


		// 查数据库，应该有i个用户
		Assert.assertEquals(i, userJpaService1.getAllUsers().intValue());

		// 删除两个用户
		userJpaService1.deleteByName("name1");
		userJpaService1.deleteByName("name2");


		// 查数据库，应该有i-2个用户
		Assert.assertEquals(i-2, userJpaService1.getAllUsers().intValue());

	}



}
