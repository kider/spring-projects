package com.spring.boot.example.proxy;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ManProxy implements MethodInterceptor {

    private Object target;

    public ManProxy(Object target){
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o,objects);
//        return method.invoke(target,objects);
    }


    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Man.class);

        enhancer.setCallback(new ManProxy(new Man()));

        Man man = (Man) enhancer.create();

        man.eat();


    }




}
