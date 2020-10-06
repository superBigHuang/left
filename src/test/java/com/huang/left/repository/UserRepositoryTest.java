package com.huang.left.repository;

import com.huang.left.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindUserName() {
        User root = userRepository.findByUsername("root");
        System.out.println("root = " + root);
    }

    @Test
    void testFind2() {
        Optional<User> byId = userRepository.findById(2L);
        System.out.println("present = " + byId.isPresent());
        System.out.println(byId.get());
    }

}