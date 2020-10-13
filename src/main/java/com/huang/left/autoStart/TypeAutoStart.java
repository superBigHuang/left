package com.huang.left.autoStart;

import com.huang.left.controller.TypeController;
import com.huang.left.entity.Type;
import com.huang.left.redis.TypeRedisDao;
import com.huang.left.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目一启动就执行typeRedis中的一些方法
 */
//@Component
public class TypeAutoStart implements CommandLineRunner {

    @Autowired
    private TypeRedisDao typeRedisDao;
    @Autowired
    private TypeService typeService;

    /**
     * 实现run方法
     * 将type的两种类型放入redis中
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        List<Type> all = typeService.findAllType();
        typeRedisDao.saveListAllType(all);
        typeRedisDao.saveListBySortType(all);
    }
}
