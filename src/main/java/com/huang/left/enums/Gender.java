package com.huang.left.enums;

/**
 * 性别枚举类
 */
public enum  Gender {
    MALE("男"),
    FEMALE("女"),
    ET("外星人");

    private String value;
    Gender(String val) {
        value = val;
    }
}
