package com.spring.boot.starter.example.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;


@Service("springBPP")
public class SpringBPPImpl implements BeanPostProcessor {

    public SpringBPPImpl() {
        System.out.println("i am SpringBPPImpl construct");
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("i am SpringBPPImpl's postProcessBeforeInitialization");

        System.out.println("i am ="+beanName);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("i am SpringBPPImpl's postProcessAfterInitialization");

        System.out.println("i am ="+beanName);

        return bean;
    }
}
