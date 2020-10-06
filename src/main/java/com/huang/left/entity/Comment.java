package com.huang.left.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 评论
 */
@Entity
@Getter
@Setter
@Table
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    private Long agreeCount;

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
