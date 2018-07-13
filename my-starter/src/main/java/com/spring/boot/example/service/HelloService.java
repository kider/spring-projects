package com.spring.boot.example.service;

public class HelloService {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public void say(){
        System.out.println("hello,"+msg);
    }
}
