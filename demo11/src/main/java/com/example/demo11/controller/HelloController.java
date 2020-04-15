package com.example.demo11.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo11.bean.User;
import com.example.demo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public JSONObject login(String name) {

        JSONObject res= new JSONObject();

        User userBean = userService.getUserPo(name);
        if (userBean != null) {
            res.put("message","success");
        } else {
            res.put("message","fail");
        }
        System.out.println(res.toString());

        return res;
    }
}