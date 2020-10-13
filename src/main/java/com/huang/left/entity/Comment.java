package com.huang.left.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评论
 */
@Entity
@Getter
@Setter
@Table
public class Comment implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Long agreeCount;


    @JsonBackReference(value = "commentBlog")
    @ManyToOne(fetch = FetchType.EAGER)
    private Blog blog;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", agreeCount=" + agreeCount +
                '}';
    }
}
