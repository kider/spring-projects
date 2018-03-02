package com.spring.boot.example.service.impl;

import com.spring.boot.example.service.UserRepository;
import com.spring.boot.example.service.UserService;
import com.spring.boot.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userJpaService")
public class UserJpaServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(String name, Integer age) {
        User u = new User(name,age);
        userRepository.save(u);
    }

    @Override
    public void deleteByName(String name) {
        User u = userRepository.findByName(name);
        userRepository.delete(u);
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
        for(int i = 1;i<=v;i++){
            User u = new User("name"+i,i);
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
