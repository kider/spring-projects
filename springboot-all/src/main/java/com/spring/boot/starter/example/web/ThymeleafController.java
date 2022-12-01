package com.spring.boot.starter.example.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {


    @RequestMapping(value = "")
    public String index(ModelMap map){
        // 加入一个属性，用来在模板中读取
        map.addAttribute("tip", "这是一个图片：");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";

    }



}
