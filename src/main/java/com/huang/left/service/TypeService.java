package com.huang.left.service;

import com.huang.left.entity.Type;

import java.util.List;
import java.util.Map;

/**
 * 话题业务逻辑接口
 */
public interface TypeService {

    // 查询所有话题
    List<Type> findAllType();
    // 通过id查找话题
    Type findById(long id);
    // 新增或修改话题
    Type saveType(Type type);
    // 通过名称查找话题
    Type findByName(String name);
    // 查询排序好的话题
    Map<String,List<Type>> findAllSortType();
    // 通过User_id查找关注的博客
    List<Type> findByUserId(Long id);
}
