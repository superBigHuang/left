package com.huang.left.repository;

import com.huang.left.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void find1() {
        List<Comment> byUser_id = commentRepository.findByUser_Id(1L, PageRequest.of(0, 2));
        for (Comment comment : byUser_id) {
            System.out.println("comment = " + comment);
        }
    }

    @Test
    public void find2() {
        List<Comment> byBlog_id = commentRepository.findByBlog_Id(1L, PageRequest.of(0, 2));
        for (Comment comment : byBlog_id) {
            System.out.println("comment = " + comment);
        }
    }
}