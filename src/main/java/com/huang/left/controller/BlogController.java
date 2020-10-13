package com.huang.left.controller;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import com.huang.left.service.BlogService;
import com.huang.left.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
        Set<User> followed = user.getFollowed();
        // 每次查询5条，按照时间排序
        return blogService.findByWatch(followed, PageRequest.of(page, PAGE_SIZE, Sort.by("createDate").descending()));
    }

    @ApiOperation("查询关注的人的所有博客的条数")
    @GetMapping("/findByWatchCount/{id}")
    public Long findByWatch(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        Set<User> followed = user.getFollowed();
        // 每次查询5条，按照时间排序
        return blogService.findCountByUser(followed);
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


    @ApiOperation("查找所有博客")
    @GetMapping("/findAll/{page}")
    public List<Blog> findAll(@PathVariable("page") Integer page) {
        Page<Blog> all = blogService.findAll(PageRequest.of(page, PAGE_SIZE, Sort.by("createDate").descending()));
        return all.hasContent() ? all.getContent() : null;
    }

    @ApiOperation("获得博客数量")
    @GetMapping("/findCount")
    public Long findCount() {
        return blogService.findBlogCount();
    }

    @ApiOperation("增加点赞数")
    @GetMapping("/addAgreeNumber/{id}")
    public Blog addAgreeNumber(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        blog.setAgreeNumber(blog.getAgreeNumber() + 1);
        return blogService.updateBlog(blog);
    }

    @ApiOperation("减少点赞数")
    @GetMapping("/subAgreeNumber/{id}")
    public Blog subAgreeNumber(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        blog.setAgreeNumber(blog.getAgreeNumber() - 1);
        return blogService.updateBlog(blog);
    }


}
