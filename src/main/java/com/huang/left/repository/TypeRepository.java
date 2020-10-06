package com.huang.left.repository;

import com.huang.left.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeRepository extends JpaRepository<Type,Long>, JpaSpecificationExecutor<Type> {
    // 根据名称查找
    Type findByTypeName(String typeName);
}
