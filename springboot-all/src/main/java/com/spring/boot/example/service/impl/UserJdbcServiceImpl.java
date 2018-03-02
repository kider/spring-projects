package com.spring.boot.example.service.impl;

import com.spring.boot.example.service.UserService;
import com.spring.boot.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "userJdbcService")
public class UserJdbcServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserJdbcServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        logger.debug("create t_user name:{},age:{}",name,age);
        jdbcTemplate.update("insert into T_USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        logger.debug("delete t_user name:{}",name);
        jdbcTemplate.update("delete from T_USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        logger.debug("get all t_user");
        return jdbcTemplate.queryForObject("select count(1) from T_USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        logger.debug("delete all t_user");
        jdbcTemplate.update("delete from T_USER");
    }

    @Override
    public void createBath(int v) {
        for(int i = 1;i<=v;i++){
            jdbcTemplate.update("insert into T_USER(NAME, AGE) values(?, ?)", "name"+i,i);
        }
    }

    @Override
    public User findByName(String name) {

        List<Map<String,Object>> dataList = jdbcTemplate.queryForList("select ID,NAME,AGE from T_USER WHERE name =?",name);

        if(null!=dataList && 0<dataList.size()){
            Map<String,Object> map = dataList.iterator().next();
            User u = new User();
            u.setId((Long)map.get("ID"));
            u.setName((String)map.get("NAME"));
            u.setAge((Integer)map.get("AGE"));
            return u;
        }

        return null;
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("update T_USER set name = ? , age = ? where id = ?",user.getName(),user.getAge(),user.getId());
    }
}
