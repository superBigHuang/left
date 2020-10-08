package com.huang.left.service;

import com.huang.left.entity.Blog;
import com.huang.left.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    /**
     * 通过博客id查找博客
     * @param id 博客id
     * @return 博客实体
     */
    Blog findById(Long id);

    /**
     * 查找关注者的博客
     * @param user 用户信息
     * @param pageable 分页
     * @return 查找到的所有博客
     */
    List<Blog> findByWatch(User user, Pageable pageable);

    /**
     * 通过博客内容查找
     * @param content 内容
     * @return 查找到的所有博客
     */
    List<Blog> findByContent(String content);

    /**
     * 通过用户id查找
     * @param id 用户id
     * @param pageable 分页
     * @return 查找到的所有博客
     */
    List<Blog> findByUserId(Long id,Pageable pageable);

    /**
     * 增加新博客
     * @param blog 博客信息
     * @return 新增好的博客信息
     */
    Blog addBlog(Blog blog);

    /**
     * 查询所有博客
     * @return 所有博客信息
     */
    Page<Blog> findAll(Pageable pageable);

    /**
     * 获得博客数量
     * @return  博客数量
     */
    Long findBlogCount();

    /**
     * 修改博客
     * @param blog 修改好的博客
     * @return 修改好的博客
     */
    Blog updateBlog(Blog blog);
}
