package com.example.springboot1.service;

import com.example.springboot1.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
}
