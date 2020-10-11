package com.huang.left.redis;

import com.huang.left.entity.Blog;
import com.huang.left.entity.Type;
import com.huang.left.repository.TypeRepository;
import com.huang.left.utils.SortTypesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TypeRedisDao {

    @Autowired
    private RedisTemplate redisTemplate;

    public static String SORT_TYPE = "sortType";
    public static String ALL_TYPE = "all_type";
    public static Integer START_INDEX = 0;



    /**
     * 往redis中添加排序好的博客类型
     */
    public void saveListBySortType(List<Type> all) {
        Map<String, List<Type>> stringListMap = SortTypesUtil.sortTypesByFirstLetter(all);
        Set<String> names = stringListMap.keySet();
        for (String name : names) {
            redisTemplate.boundHashOps(SORT_TYPE).put(name, stringListMap.get(name));
        }
    }

    /**
     * 获取redis中排序好的博客类型
     *
     * @return 排序好的Map
     */
    public Map<String, List<Type>> getMapBySortType() {
        Set<String> keys = redisTemplate.boundHashOps(SORT_TYPE).keys();
        Map<String, List<Type>> stringListMap = new HashMap<>();
        for (String key : keys) {
            List<Type> sortType = (List<Type>) redisTemplate.boundHashOps("sortType").get(key);
            stringListMap.put(key, sortType);
        }
        return stringListMap;
    }

    /**
     * 往redis中添加所有博客类型
     * @param all
     */
    public void saveListAllType(List<Type> all) {
        for (Type type : all) {
            redisTemplate.boundListOps(ALL_TYPE).leftPush(type);
        }
    }

    /**
     * 获得所有的博客类型
     * @return
     */
    public List<Type> getListAllType() {
        Long size = redisTemplate.boundListOps(ALL_TYPE).size();
        return redisTemplate.boundListOps(ALL_TYPE).range(START_INDEX, size);
    }




}
