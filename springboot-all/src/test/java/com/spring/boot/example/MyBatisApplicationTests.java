package com.spring.boot.example;

import com.spring.boot.example.dao.CityDao;
import com.spring.boot.example.dao.HotelDao;
import com.spring.boot.example.dto.UserDto;
import com.spring.boot.example.entity.Hotel;
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

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class MyBatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private HotelDao hoteldao;

    @Autowired
    SqlSessionFactory sqlSessionFactory;


    @Test
    @Rollback
    public void testBatchInsert() throws Exception {
        long startTime = System.currentTimeMillis();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 5000; i++) {
            userMapper.insert("chenhao" + i, i);
        }
        sqlSession.commit();
        long endTime = System.currentTimeMillis();
        System.out.printf("共消耗时间:%s ms", endTime - startTime);
    }


    @Test
    @Rollback
    public void testMyBatis1() throws Exception {
        userMapper.insert("chenhao", 28);
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
