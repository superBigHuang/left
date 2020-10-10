package com.huang.left.utils;

import com.huang.left.entity.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 博客类型排序工具类
 */
public class SortTypesUtil {
    /**
     * 根据类型的首字母对类型进行排序
     * @param all 所有的博客类型
     * @return 排序好后的map集合
     */
    public static Map<String, List<Type>> sortTypesByFirstLetter(List<Type> all) {
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
        return sortType;
    }
}
