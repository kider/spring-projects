package com.spring.boot.starter.example.service.impl;

import com.spring.boot.starter.example.entity.User;
import com.spring.boot.starter.example.service.OrderService;
import com.spring.boot.starter.example.service.UserRepository;
import com.spring.boot.starter.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userJpaService")
public class UserJpaServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserJpaServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderJpaService;

    @Override
    public void create(String name, Integer age) {
        User u = new User(name, age);
        userRepository.save(u);
    }

    @Override
    public void deleteByName(String name) {
        User u = userRepository.findUser(name);
        userRepository.delete(u);
        //删除此用户下的订单
        // try {
        orderJpaService.deleteByUid(u.getId());
        //} catch (Exception e) {
        //logger.error("删除订单失败");
        //}
    }

    @Override
    public Integer getAllUsers() {
        return userRepository.findAll().size();
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void createBath(int v) {
        for (int i = 1; i <= v; i++) {
            User u = new User("name" + i, i);
            userRepository.save(u);
        }
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
