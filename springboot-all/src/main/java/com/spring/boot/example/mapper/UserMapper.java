package com.spring.boot.example.mapper;


import com.spring.boot.example.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE NAME = #{name}")
    UserDto findByName(@Param("name") String name);

    @Insert("INSERT INTO t_user(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
