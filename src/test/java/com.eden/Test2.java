package com.eden;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/6/22
 * @Version V1.0
 **/
public class Test2 {
    @Test
    public void fun() {
        Map<String,List<List<String>>> map1=new HashMap<>();
        Map<String,List<List<String>>>  map2=new HashMap<>();
        List<List<String>> list1s=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        list1.add("a1");
        list1.add("b1");
        List<String> list2=new ArrayList<>();
        list2.add("a2");
        list2.add("b2");
        list1s.add(list1);
        list1s.add(list2);
        List<List<String>> list12s=new ArrayList<>();
        List<String> list3=new ArrayList<>();
        list3.add("c1");
        list3.add("c2");
        List<String> list4=new ArrayList<>();
        list4.add("c3");
        list4.add("c4");
        list12s.add(list3);
        list12s.add(list4);

        map1.put("1",list1s);

        map2.put("1",list12s);
        map1.putAll(map2);

    }
}
