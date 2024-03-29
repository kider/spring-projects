package com.spring.boot.example.service;

import com.spring.boot.example.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(key = "#name")
    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("select u from User u where u.name=:name")
    User findUser(@Param("name") String name);

    @Override
    @CachePut(key = "#p0.name")
    User save(User user);


    @Override
    @CacheEvict(key = "#p0.name")
    void delete(User user);
}
