package com.spring.boot.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ServiceA
 * @Description TODO
 * @Author kider
 * @Date 2022/12/1 21:36
 * @Version 1.0
 **/
@Service
public class ServiceA {

    @Autowired
    private ServiceB serviceB;

}
