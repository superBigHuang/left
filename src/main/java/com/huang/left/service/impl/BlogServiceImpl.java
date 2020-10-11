package com.huang.left.service.impl;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import com.huang.left.repository.BlogRepository;
import com.huang.left.repository.UserRepository;
import com.huang.left.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;


    @Override
    public Blog findById(Long id) {
        Optional<Blog> byId = blogRepository.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }

    @Override
    public List<Blog> findByWatch(User user, Pageable pageable) {
        return blogRepository.findByUser_Fans(user, pageable);
    }

    @Override
    public List<Blog> findByContent(String content) {
        return blogRepository.findByContent(content);
    }

    @Override
    public List<Blog> findByUserId(Long id, Pageable pageable) {
        return blogRepository.findByUser_Id(id, pageable);
    }

    @Override
    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return  blogRepository.findAll(pageable);

    }

    @Override
    public Long findBlogCount() {
        return blogRepository.count();
    }

    @Override
    public Blog updateBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
