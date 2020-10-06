package com.huang.left.controller;

import com.huang.left.entity.User;
import com.huang.left.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("通过用户名查找")
    @GetMapping("/findUserName/{username}")
    public String findByUserName(@PathVariable("username") String username) {
        User user = userService.findByUserName(username);
        if (user == null) {
            return "success";
        } else {
            return "error";
        }
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("user = " + user);
        return userService.register(user);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        System.out.println("user = " + user);
        return userService.login(user.getUsername(),user.getPassword());
    }

}
