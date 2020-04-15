package com.example.demo11.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {


    @RequestMapping("/index")
    public String hello() {
        System.out.println("sdaasds");
        return "index";
    }

    @RequestMapping("/loginIn")
    public String loginIn() {
        return "login";
    }




}