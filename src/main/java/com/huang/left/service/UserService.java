package com.huang.left.service;

import com.huang.left.entity.User;

public interface UserService {
    /**
     * 通过用户名查找改用户是否存在
     * @param username 用户名
     * @return 存在就返回整个用户信息
     */
    User findByUserName(String username);

    /**
     * 注册
     * @param user 封装的用户信息
     * @return 注册成功后返回的用户信息
     */
    User register(User user);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功后返回的用户信息
     */
    User login(String username,String password);

    /**
     * 根据用户id查询
     * @param id 用户id
     * @return 用户信息
     */
    User findById(Long id);
}
