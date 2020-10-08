package com.huang.left.repository;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    // 查询关注的人的所有博客
    List<Blog> findByUser_Fans(User user, Pageable pageable);

    // 根据内容查询
    List<Blog> findByContent(String content);

    // 根据用户id查询
    List<Blog> findByUser_Id(Long id, Pageable pageable);


}
