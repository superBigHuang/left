package com.huang.left.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
public class Blog implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    // 内容
    private String content;
    // 创建时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    // 点赞数
    private Integer agreeNumber;
    // 图片url
    private String ImgUrl;
    // 将url切割
    @Transient
    private String[] urls;

    public String[] getUrls() {
        return ImgUrl != null ? ImgUrl.split(";") : null;
    }

    @JsonIgnoreProperties(value = {"blogs"})
    @ManyToOne(fetch = FetchType.EAGER)
    private Type type;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnoreProperties(value = {"blogs"})
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


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
