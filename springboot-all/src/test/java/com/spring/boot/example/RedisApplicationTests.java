package com.spring.boot.example;

import com.spring.boot.example.entity.User;
import com.spring.boot.example.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class RedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private UserService userJpaService;


	@Test
	public void test() throws Exception {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("hhh", "888");
		Assert.assertEquals("888", stringRedisTemplate.opsForValue().get("hhh"));

	}


	@Test
	public void testJpaRedisQuery() throws Exception {
		// 准备，清空user表
		userJpaService.deleteAllUsers();
		int i = 5;
		// 插入5个用户
		userJpaService.createBath(i);

		User u = userJpaService.findByName("name1");

		System.out.println(u.toString());

		u.setAge(19);

		userJpaService.updateUser(u);

		u = userJpaService.findByName("name1");

		userJpaService.findByName("name1");

		System.out.println(u.toString());

	}

}
