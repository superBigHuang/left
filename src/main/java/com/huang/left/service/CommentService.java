package com.huang.left.service;

import com.huang.left.entity.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 评论业务逻辑接口
 */
public interface CommentService {
    // 通过博客Id查找该博客下面所有的评论
    public List<Comment> findByBlogId(Long id, Pageable pageable);
    // 通过用户Id查找该用户所有评论
    public List<Comment> findByUserId(Long id, Pageable pageable);
    // 通过评论id查找
    public Comment findById(Long id);
    // 新增评论
    public Comment addComment(Comment comment);
}
