package com.spring.boot.starter.example;

import com.spring.boot.starter.example.dao.CityDao;
import com.spring.boot.starter.example.dao.HotelDao;
import com.spring.boot.starter.example.entity.Hotel;
import com.spring.boot.starter.example.entity.User;
import com.spring.boot.starter.example.mapper.UserMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.util.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class MyBatisApplicationTests {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private HotelDao hoteldao;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testBatchInsert() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setName("chenhao" + i);
            user.setAge(i);
            userMapper.insertOne(user);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("testBatchInsert 共消耗时间:%s ms", endTime - startTime);
    }

    @Test
    public void testBatchInsert1() throws Exception {
        long startTime = System.currentTimeMillis();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setName("chenhao" + i);
            user.setAge(i);
            users.add(user);
        }
        userMapper.addByOneSQL(users);
        long endTime = System.currentTimeMillis();
        System.out.printf("testBatchInsert1 共消耗时间:%s ms", endTime - startTime);
    }

    @Test
    public void testBatchInsert2() throws Exception {
        Calendar calendar = DateUtils.createNow();
        long startTime = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int age = 1;
        for (int i = 0; i < 10000; i++) {
            calendar.add(Calendar.SECOND, i);
            User user = new User();
            if (0 == i % 100) {
                age++;
            }
            user.setName("chenhao" + age);
            user.setAge(age);
            user.setSex("男");
            user.setContent("是一个程序员");
            user.setCreateTime(calendar.getTime());
            userMapper.insertOne(user);
        }
        sqlSession.commit();
        long endTime = System.currentTimeMillis();
        System.out.printf("testBatchInsert2 共消耗时间:%s ms", endTime - startTime);
    }

    @Test
    public void testBatchInsert3() throws Exception {
        long startTime = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setName("chenhao" + i);
            user.setAge(i);
            users.add(user);
        }
        userMapper.addByOneSQL(users);
        sqlSession.commit();
        long endTime = System.currentTimeMillis();
        System.out.printf("testBatchInsert3 共消耗时间:%s ms", endTime - startTime);
    }


    @Test
    @Rollback
    public void testMyBatis1() throws Exception {
        User user = new User();
        user.setName("chenhao");
        user.setAge(28);
        userMapper.insertOne(user);
        User u = userMapper.findByName("chenhao");
        Assert.assertEquals(28, u.getAge().intValue());
    }

    @Test
    @Rollback
    public void testMyBatis2() throws Exception {

//		City city = cityDao.selectCityById(1L);
//
//		Hotel hotel = hoteldao.selectByCity(city);

        Hotel hotel = new Hotel();

        hotel.setState(1);

        List<Hotel> listHotel = hoteldao.selectByHotel(hotel);

//		System.out.println(city.toString());

        listHotel.forEach((h) -> System.out.println(h.toString()));

    }

}
