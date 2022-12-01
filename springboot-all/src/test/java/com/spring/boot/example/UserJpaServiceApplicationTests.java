package com.spring.boot.example;

import com.spring.boot.example.entity.User;
import com.spring.boot.example.service.OrderService;
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
    private UserService userJpaService;

    @Autowired
    @Qualifier("orderJpaService")
    private OrderService orderJpaService;

    @Before
    public void setUp() {
        // 准备，清空user表
        //userJpaService.deleteAllUsers();
    }

    @Test
    public void clearUser() {
        userJpaService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {

        int i = 9;

        userJpaService.createBath(i);


        // 查数据库，应该有i个用户
        Assert.assertEquals(i, userJpaService.getAllUsers().intValue());

        // 删除两个用户
        userJpaService.deleteByName("name1");
        userJpaService.deleteByName("name2");


        // 查数据库，应该有i-2个用户
        Assert.assertEquals(i - 2, userJpaService.getAllUsers().intValue());

    }

    @Test
    public void createUserAndOrder() {
        userJpaService.create("chenhao", 31);
        User user = userJpaService.findByName("chenhao");
        orderJpaService.create(user.getId(), 100);
    }


    //测试事务用
    @Test
    public void testTx() throws Exception {
        userJpaService.deleteByName("chenhao");
    }


}
