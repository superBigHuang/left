package com.huang.left.entity;

import com.huang.left.repository.TypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TypeTest {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    public void a() {
        Type type = new Type();
        type.setId(1l);
        type.setCreateTime(new Date());
        type.setHeadImg("aaa");
        type.setIntroduction("cesces");
        type.setTypeName("zszszs");
        Type save = typeRepository.save(type);
        System.out.println("save = " + save);
    }



}