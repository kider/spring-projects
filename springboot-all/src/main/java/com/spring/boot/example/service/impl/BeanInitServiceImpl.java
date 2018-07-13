package com.spring.boot.example.service.impl;

import com.spring.boot.example.service.BeanInitService;
import com.spring.boot.example.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("beanInitService")
public class BeanInitServiceImpl implements BeanInitService,BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean {


    private BeanFactory beanFactory;

    private String beanName;

    private ApplicationContext applicationContext;

    @Autowired
    private BeanInitService beanInitService;

    @Autowired
    private UserService userJdbcService;

    public BeanInitServiceImpl() {
        System.out.println("i am BeanInitServiceImpl construct before");
        System.out.println("beanFactory :"+beanFactory);
        System.out.println("beanName :"+beanName);
        System.out.println("applicationContext :"+applicationContext);
        System.out.println("i am BeanInitServiceImpl construct after");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("i am BeanInitServiceImpl setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("i am BeanInitServiceImpl setBeanName");
            this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("i am BeanInitServiceImpl setApplicationContext");
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void postConstruct(){

        System.out.println("i am BeanInitServiceImpl postConstruct");

    }

    @PreDestroy
    public void preDestroy(){

        System.out.println("i am BeanInitServiceImpl preDestroy");

    }


    @Override
    public void destroy() throws Exception {

        System.out.println("i am BeanInitServiceImpl destroy");

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("i am BeanInitServiceImpl afterPropertiesSet before");

        System.out.println("bean name :"+beanName);

        BeanInitService beanInitService1 = (BeanInitService) beanFactory.getBean("beanInitService");

        BeanInitService beanInitService2 = (BeanInitService) applicationContext.getBean("beanInitService");


        System.out.println("beanInitService:"+beanInitService);
        System.out.println("this:"+this);
        System.out.println("userJdbcService:"+userJdbcService);
        System.out.println("beanInitService1:"+beanInitService1);
        System.out.println("beanInitService2:"+beanInitService2);

        if(beanInitService1 == beanInitService2){

            System.out.println("beanInitService1 == beanInitService2");
        }

        System.out.println("i am BeanInitServiceImpl afterPropertiesSet after");





    }
}
