package com.huang.left.service.impl;

import com.huang.left.entity.Type;
import com.huang.left.redis.TypeRedisDao;
import com.huang.left.repository.TypeRepository;
import com.huang.left.service.TypeService;
import com.huang.left.utils.SortTypesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private TypeRedisDao typeRedisDao;

    @Override
    public List<Type> findAllType() {
        return typeRepository.findAll();
    }

    @Override
    public Type findById(long id) {
        Optional<Type> byId = typeRepository.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }

    /**
     * 更新完话题就更新redis中的话题
     * @param type 需要 更新/新增 的话题
     * @return 更新/新增 好的话题
     */
    @Transactional
    @Override
    public Type saveType(Type type) {
        Type save = typeRepository.save(type);
//        typeRedisDao.saveListBySortType(typeRepository.findAll());
//        typeRedisDao.saveListAllType(typeRepository.findAll());
        return save;
    }

    @Override
    public Type findByName(String name) {
        return typeRepository.findByTypeName(name);
    }

    @Override
    public Map<String, List<Type>> findAllSortType() {
        List<Type> all = typeRepository.findAll();
        return SortTypesUtil.sortTypesByFirstLetter(all);
//        return typeRedisDao.getMapBySortType();
    }

    @Override
    public List<Type> findByUserId(Long id) {
        return typeRepository.findByUsers_id(id);
    }
}
