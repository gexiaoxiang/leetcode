package com.eden;

import java.util.Collection;

/**
 * @Description: 集合工具类 -test
 * @Author gexx
 * @Date 2020/12/11
 * @Version V1.0
 **/
public class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
}
