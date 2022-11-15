package com.spring.boot.example.mapper;


import com.spring.boot.example.dto.UserDto;
import com.spring.boot.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //@Select("SELECT * FROM t_user WHERE NAME = #{name}")
    UserDto findByName(@Param("name") String name);

    //@Insert("INSERT INTO t_user(NAME, AGE) VALUES(#{name}, #{age})")
    int insertOne(@Param("name") String name, @Param("age") Integer age);


    int insertOneSQL(List<User> users);

}
