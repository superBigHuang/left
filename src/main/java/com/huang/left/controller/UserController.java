package com.huang.left.controller;

import com.huang.left.entity.User;
import com.huang.left.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
        return userService.login(user.getUsername(), user.getPassword());
    }

    @ApiOperation("通过id获得该id关注的列表")
    @GetMapping("/getWatch/{id}")
    public Set<User> getWatch(@PathVariable Long id) {
        User user = userService.findById(id);
        return user.getFollowed();
    }

    @ApiOperation("通过id获得关注该id的列表")
    @GetMapping("/getFans/{id}")
    public Set<User> getFans(@PathVariable Long id) {
        User user = userService.findById(id);
        return user.getFans();
    }

    @ApiOperation("关注")
    @PostMapping("/watch/{userId}/{watchId}")
    public Set<User> watch(@PathVariable("userId") Long userId,
                      @PathVariable("watchId") Long watchId) {
        User watch = userService.watch(userId, watchId);
        return getWatch(watch.getId());
    }

}
