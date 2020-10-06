package com.huang.left.service.impl;

import com.huang.left.entity.User;
import com.huang.left.repository.UserRepository;
import com.huang.left.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }
}
