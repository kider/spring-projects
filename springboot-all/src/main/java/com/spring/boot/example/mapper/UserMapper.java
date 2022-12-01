package com.spring.boot.example.mapper;


import com.spring.boot.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    //@Select("SELECT * FROM t_user WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    //@Insert("INSERT INTO t_user(NAME, AGE) VALUES(#{name}, #{age})")
    int insertOne(User user);


    int addByOneSQL(@Param("users") List<User> users);

}
