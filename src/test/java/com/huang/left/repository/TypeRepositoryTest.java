package com.huang.left.repository;

import com.huang.left.entity.Type;
import com.huang.left.utils.ChineseToFirstLetterUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TypeRepositoryTest {
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void test1() {
        Type type1 = new Type();

        type1.setHeadImg("https://c-ssl.duitang.com/uploads/item/201803/29/20180329123436_cdxdp.jpeg");
        type1.setTypeName("JAVA");
        type1.setIntroduction("JAVA是最好的语言");
        type1.setCreateTime(new Date());

        typeRepository.save(type1);
    }

    @Test
    void test2() {
        List<Type> all = typeRepository.findAll();
        Map<String, List<Type>> sortType = new HashMap<>();
        for (Type type : all) {
            String typeName = type.getTypeName();
            String s = ChineseToFirstLetterUtil.ChineseToFirstLetter(typeName);
            boolean b = sortType.containsKey(s);
            if (b) {
                List<Type> types = sortType.get(s);
                types.add(type);
                sortType.put(s, types);
            } else {
                List<Type> types = new ArrayList<>();
                types.add(type);
                sortType.put(s, types);
            }
        }
//        for (String s : sortType.keySet()) {
//            System.out.print(s +"====>");
//            System.out.println(sortType.get(s));
//        }

        Set<String> names = sortType.keySet();
        for (String name : names) {
            redisTemplate.boundHashOps("sortType").put(name,sortType.get(name));
        }



    }

    @Test
    void test3() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "B");
        map.put("C", "G");
        map.put("D", "F");
        System.out.println(map.containsKey("A"));
        System.out.println(map.put("E", new String("!")));
    }

    @Test
    void test4() {
        Set keys = redisTemplate.boundHashOps("sortType").keys();
        for (Object key : keys) {
            System.out.print("key = " + key + "===>");
            List<Type> sortType = (List<Type>)redisTemplate.boundHashOps("sortType").get(key);
            for (Type type : sortType) {
                System.out.println("type = " + type);
            }
        }
    }
}