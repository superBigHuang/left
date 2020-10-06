package com.huang.left.controller;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import com.huang.left.service.BlogService;
import com.huang.left.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;


    public static final int PAGE_SIZE = 5;

    @ApiOperation("根据id查找博客")
    @GetMapping("/findById/{id}")
    public Blog findById(@PathVariable Long id) {
        return blogService.findById(id);
    }

    @ApiOperation("查询关注的人的所有博客")
    @GetMapping("/findByWatch/{id}/{page}")
    public List<Blog> findByWatch(@PathVariable("id") Long id,
                                  @PathVariable("page") Integer page) {
        User user = userService.findById(id);
        // 每次查询5条，按照时间排序
        return blogService.findByWatch(user, PageRequest.of(page, PAGE_SIZE, Sort.by("createDate").descending()));
    }

    @ApiOperation("通过内容查找")
    @GetMapping("/findByContent/{content}")
    public List<Blog> findByContent(@PathVariable String content) {
        return blogService.findByContent(content);
    }

    @ApiOperation("通过用户id查找")
    @GetMapping("/findByUserID/{id}/{page}")
    public List<Blog> findByUserId(@PathVariable("id") Long id,
                                   @PathVariable("page") Integer page) {
        return blogService.findByUserId(id, PageRequest.of(page, PAGE_SIZE, Sort.by("createDate").descending()));
    }

    @ApiOperation("新增博客")
    @PostMapping("/addBlog")
    public Blog addBlog(@RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

}
