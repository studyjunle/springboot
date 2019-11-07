package com.example.springboot1.service.impl;

import com.example.springboot1.dao.UserMapper;
import com.example.springboot1.entity.User;
import com.example.springboot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
