package com.huang.left.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 帖子
 */
@Entity
@Table()
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    // 内容
    private String content;
    // 创建时间
    @Temporal(TemporalType.DATE)
    private Date createDate;
    // 点赞数
    private Integer agreeNumber;
    // 图片url
    private String ImgUrl;
    // 将url切割
//    @Transient
//    private String[] urls = (ImgUrl.equals("") ? new String[]{} : ImgUrl.split(";"));

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Type type;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", agreeNumber=" + agreeNumber +
                ", ImgUrl='" + ImgUrl + '\'' +
                '}';
    }
}
