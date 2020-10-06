package com.huang.left.service.impl;

import com.huang.left.entity.Type;
import com.huang.left.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TypeServiceImplTest {

    @Autowired
    private TypeService typeService;
    @Test
    public void test1() {
        System.out.println(typeService.findById(1l));
    }

    @Test
    public void test2() {
        List<Type> allType = typeService.findAllType();
        for (Type type : allType) {
            System.out.println("type = " + type);
        }
    }

    @Test
    public void test3() {
        Type type = new Type();
        type.setTypeName("dddd");
        type.setHeadImg("dwadad");
        Type type1 = typeService.saveType(type);
        System.out.println("type1 = " + type1);
    }

    @Test
    public void test4() {
        Type type = new Type();
        type.setId(3l);
        type.setTypeName("dddd");
        type.setHeadImg("dwadad");
        Type type1 = typeService.saveType(type);
        System.out.println("type1 = " + type1);
    }


}