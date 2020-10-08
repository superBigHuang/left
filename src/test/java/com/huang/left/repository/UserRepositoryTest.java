package com.huang.left.repository;

import com.huang.left.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

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
        Set<User> fans = byId.get().getFans();
        for (User fan : fans) {
            System.out.println("fan = " + fan);
        }
        Set<User> followed = byId.get().getFollowed();
        for (User user : followed) {
            System.out.println("user = " + user);
        }
    }
    @Test
    void testAddFan() {
        User user = userRepository.findById(2L).get();
        User user2 = userRepository.findById(4L).get();
//        user.getFans().add(user2);
        user.getFollowed().add(user2);
        userRepository.save(user);
    }

}