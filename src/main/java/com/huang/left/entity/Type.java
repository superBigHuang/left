package com.huang.left.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * 板块
 */
@Getter
@Setter
@Entity
@Table()
public class Type implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    // 头像
    private String headImg;
    // 名称
    private String typeName;
    // 简介
    private String introduction;
    // 创建日期
    @Temporal(TemporalType.DATE)
    private Date createTime;


    @JsonBackReference(value = "typeBlogs")
    @OneToMany(mappedBy = "type",fetch = FetchType.EAGER)
    private Set<Blog> blogs = new HashSet<>();

    @JsonBackReference(value = "typeUsers")
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", headImg='" + headImg + '\'' +
                ", typeName='" + typeName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
