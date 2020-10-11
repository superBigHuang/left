package com.huang.left.redis;

import com.huang.left.entity.Blog;
import com.huang.left.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRedisDao {

    @Autowired
    private RedisTemplate redisTemplate;

    public static String ALL_BLOG = "all_blog";
    public static Integer START_INDEX = 0;

    /**
     * 往redis中添加所有博客
     * @param all
     */
    public void saveListAllBLog(List<Blog> all) {
        for (Blog blog : all) {
            redisTemplate.boundListOps(ALL_BLOG).leftPush(blog);
        }
    }

    /**
     * 获得所有的博客
     * @return
     */
    public List<Type> getListAllBLog() {
        Long size = redisTemplate.boundListOps(ALL_BLOG).size();
        return redisTemplate.boundListOps(ALL_BLOG).range(START_INDEX, size);
    }
}
