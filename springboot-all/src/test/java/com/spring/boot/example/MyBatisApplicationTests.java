package com.spring.boot.example;

import com.spring.boot.example.dao.CityDao;
import com.spring.boot.example.dao.HotelDao;
import com.spring.boot.example.dto.UserDto;
import com.spring.boot.example.entity.Hotel;
import com.spring.boot.example.entity.User;
import com.spring.boot.example.mapper.UserMapper;
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

import java.util.ArrayList;
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
            userMapper.insertOne("chenhao" + i, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("共消耗时间:%s ms", endTime - startTime);
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
        userMapper.insertOneSQL(users);
        long endTime = System.currentTimeMillis();
        System.out.printf("共消耗时间:%s ms", endTime - startTime);
    }

    @Test
    public void testBatchInsert2() throws Exception {
        long startTime = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setName("chenhao" + i);
            user.setAge(i);
            userMapper.insertOne("chenhao" + i, i);
        }
        sqlSession.commit();
        long endTime = System.currentTimeMillis();
        System.out.printf("共消耗时间:%s ms", endTime - startTime);
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
        userMapper.insertOneSQL(users);
        sqlSession.commit();
        long endTime = System.currentTimeMillis();
        System.out.printf("共消耗时间:%s ms", endTime - startTime);
    }


    @Test
    @Rollback
    public void testMyBatis1() throws Exception {
        userMapper.insertOne("chenhao", 28);
        UserDto u = userMapper.findByName("chenhao");
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
