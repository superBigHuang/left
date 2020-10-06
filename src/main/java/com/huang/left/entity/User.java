package com.huang.left.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huang.left.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * 用户
 */
@Table
@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String introduction;
    private String headImg;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Blog> blogs = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    // 用户内连关系

    // 被关注的人
    @JsonIgnore
    @JsonIgnoreProperties({"fans"})
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Set<User> followed = new HashSet<>();
    // 粉丝

    @JsonIgnore
    @ManyToMany(mappedBy = "followed", fetch = FetchType.EAGER)
    private Set<User> fans = new HashSet<>();




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", introduction='" + introduction + '\'' +
                ", headImg='" + headImg + '\'' +
                ", blogs=" + blogs +
                ", comments=" + comments +
                '}';
    }
}
