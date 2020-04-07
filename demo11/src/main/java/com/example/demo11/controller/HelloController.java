package com.example.demo11.controller;


import com.example.demo11.bean.User;
import com.example.demo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String hello() {
        System.out.println("sdaasds");
        return "index";
    }

    @RequestMapping("/loginIn")
    public String loginIn() {
        return "login";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String name) {

        System.out.println(name);

        User userBean = userService.getUserPo(name);

        System.out.println(userBean);

        if (userBean != null) {
            return "success";
        } else {
            return "login";
        }

    }
}