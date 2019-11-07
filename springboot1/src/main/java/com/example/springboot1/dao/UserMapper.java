package com.example.springboot1.dao;

import com.example.springboot1.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAllUser();
}
