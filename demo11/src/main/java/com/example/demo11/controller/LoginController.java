package com.example.demo11.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo11.bean.User;
import com.example.demo11.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


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
        System.out.println(res.toString());

        return res;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public User register(User user) {

        String username = user.getUserName();
        String password = user.getPassWord();
        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassWord(encodedPassword);

        userService.addUser(user);
        return user;
    }

    @RequestMapping("/regIn")
    public ModelAndView regIn() {
        ModelAndView view = new ModelAndView("/register.html");
        return view;
    }
}