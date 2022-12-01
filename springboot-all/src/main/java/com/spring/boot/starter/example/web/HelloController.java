package com.spring.boot.starter.example.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
//@Scope(value = "prototype")
public class HelloController {


    @RequestMapping("/hello")
    public String index(HttpServletRequest request, HttpServletResponse response,@RequestParam String name) {

        System.out.println(request.getSession().getId());

        Cookie[] cookies = request.getCookies();

        System.out.println(cookies);

        return "Hello " +name;
    }


}
