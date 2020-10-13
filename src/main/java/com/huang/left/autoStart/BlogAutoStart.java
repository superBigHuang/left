package com.huang.left.autoStart;

import com.huang.left.controller.BlogController;
import com.huang.left.entity.Blog;
import com.huang.left.redis.BlogRedisDao;
import com.huang.left.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class BlogAutoStart implements CommandLineRunner {

    @Autowired
    private BlogRedisDao blogRedisDao;
    @Autowired
    private BlogService blogService;

    @Override
    public void run(String... args) throws Exception {
        List<Blog> all = blogService.findAll();
        blogRedisDao.saveListAllBLog(all);
    }
}
