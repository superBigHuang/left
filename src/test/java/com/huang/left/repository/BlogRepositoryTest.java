package com.huang.left.repository;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import sun.text.normalizer.UBiDiProps;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void find1() {
        Optional<User> byId = userRepository.findById(2L);
        System.out.println("byId = " + byId.isPresent());
        User user = byId.get();
        System.out.println("user = " + user);


        List<Blog> byUserWatch = blogRepository.findByUser_Fans(user, PageRequest.of(1,1));
        for (Blog userWatch : byUserWatch) {
            System.out.println("userWatch = " + userWatch);
        }
    }

    @Test
    public void find2() {
        List<Blog> byUser_id = blogRepository.findByUser_Id(1L, PageRequest.of(0, 5));
        for (Blog blog : byUser_id) {
            System.out.println("blog = " + blog);
        }
    }

    @Test
    public void find3() {
        List<Blog> byUser_id = blogRepository.findByContent("1");
        for (Blog blog : byUser_id) {
            System.out.println("blog = " + blog);
        }
    }



}