package com.huang.left.repository;

import com.huang.left.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    // 判断用户名是否存在
    User findByUsername(String userName);

    // 通过用户名密码登录
    User findByUsernameAndPassword(String username, String password);


}
