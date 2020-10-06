package com.huang.left.service.impl;

import com.huang.left.entity.Comment;
import com.huang.left.repository.CommentRepository;
import com.huang.left.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findByBlogId(Long id, Pageable pageable) {
        return commentRepository.findByBlog_Id(id, pageable);
    }

    @Override
    public List<Comment> findByUserId(Long id, Pageable pageable) {
        return commentRepository.findByUser_Id(id, pageable);
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> byId = commentRepository.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
