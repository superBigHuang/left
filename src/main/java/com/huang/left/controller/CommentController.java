package com.huang.left.controller;

import com.huang.left.entity.Comment;
import com.huang.left.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    public static final int PAGE_SIZE = 8;

    @ApiOperation("通过id查找评论")
    @GetMapping("/findById/{id}")
    public Comment findById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @ApiOperation("通过博客id查找评论")
    @GetMapping("/findByBlogId/{id}/{page}/{mode}")
    public List<Comment> findByBlogId(@PathVariable("id") Long id,
                                      @PathVariable("page") int page,
                                      @PathVariable("mode") String mode) {
        List<Comment> comments;
        // 排序规则
        if ("time".equals(mode)) {
            // 按照时间排序
            PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE, Sort.by("createTime").descending());
            comments = commentService.findByBlogId(id, pageRequest);
        } else {
            // 按照点赞数排序
            PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE, Sort.by("agreeCount").descending());
            comments =  commentService.findByBlogId(id, pageRequest);
        }
        return comments;

    }

    @ApiOperation("通过用户id查找评论")
    @GetMapping("/findByUserId/{id}/{page}/{mode}")
    public List<Comment> findByUserId(@PathVariable("id") Long id,
                                      @PathVariable("page") int page,
                                      @PathVariable("mode") String mode) {
        List<Comment> comments;
        // 排序规则
        if ("time".equals(mode)) {
            // 按照时间排序
            PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE, Sort.by("createTime").descending());
            comments =  commentService.findByUserId(id, pageRequest);
        } else {
            // 按照点赞数排序
            PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE, Sort.by("agreeCount").descending());
            comments = commentService.findByUserId(id, pageRequest);
        }
        return comments;
    }

    @ApiOperation("新增评论")
    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
}
