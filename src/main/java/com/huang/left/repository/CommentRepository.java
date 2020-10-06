package com.huang.left.repository;

import com.huang.left.entity.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
    // 通过BolgID查找Comment
    List<Comment> findByBlog_Id(Long id, Pageable pageable);

    // 通过UserId查找Comment
    List<Comment> findByUser_Id(Long id, Pageable pageable);

}
