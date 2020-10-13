package com.huang.left.repository;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {



    // 根据内容查询
    List<Blog> findByContent(String content);

    // 根据用户id查询
    List<Blog> findByUser_Id(Long id, Pageable pageable);

    // 查询关注的人的博客数量
    Long countBlogsByUserIn(Collection<User> users);

    // 查询多个用户发布过的博客
    List<Blog> findByUserIn(Collection<User> users, Pageable pageable);


}
