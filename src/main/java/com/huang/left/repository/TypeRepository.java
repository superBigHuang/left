package com.huang.left.repository;

import com.huang.left.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long>, JpaSpecificationExecutor<Type> {
    // 根据名称查找
    Type findByTypeName(String typeName);

    // 根据用户id查询关注的类型
    List<Type> findByUser_Id(Long id);
}
