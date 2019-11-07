package com.example.springboot1.controller;

import com.example.springboot1.entity.User;
import com.example.springboot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model) {
        List<User> user = userService.findAllUser();
        model.addAttribute("users", user);
        return "list";
    }
}
