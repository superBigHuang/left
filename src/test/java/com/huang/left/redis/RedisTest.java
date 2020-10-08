package com.huang.left.redis;

import com.huang.left.utils.ChineseToFirstLetterUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.lang.model.SourceVersion;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        redisTemplate.boundValueOps("age").set("60");
    }

    @Test
    public void test2() {
        Object age = redisTemplate.boundValueOps("age").get();
        System.out.println("age = " + age);
    }

    @Test
    public void test3() {
        Boolean age = redisTemplate.delete("age");
        System.out.println("age = " + age);
    }


    @Test
    public void test4() {
        String s = ChineseToFirstLetterUtil.ChineseToFirstLetter("台湾");
        System.out.println("s = " + s);
    }
}
