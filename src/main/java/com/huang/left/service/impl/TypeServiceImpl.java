package com.huang.left.service.impl;

import com.huang.left.entity.Type;
import com.huang.left.repository.TypeRepository;
import com.huang.left.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> findAllType() {
        return typeRepository.findAll();
    }

    @Override
    public Type findById(long id) {
        Optional<Type> byId = typeRepository.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type findByName(String name) {
        return typeRepository.findByTypeName(name);
    }
}
