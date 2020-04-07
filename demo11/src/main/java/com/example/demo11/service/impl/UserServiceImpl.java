package com.example.demo11.service.impl;

import com.example.demo11.bean.User;
import com.example.demo11.mapper.UserMapper;
import com.example.demo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserPo(String userName) {
        return userMapper.getUserPo(userName);
    }
}
