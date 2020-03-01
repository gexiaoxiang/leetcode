package com.eden.explore.datastructure.hashtables;

import java.util.*;

/**
 * @author gexx
 * @Description 实际应用哈希集合
 * @Date 2020/2/29
 **/
public class PracticalApplication {


    /**
     * @Description 两个数组的交集
     * @author gexx
     * @Date 2020/2/29
     **/
    public static int[] intersection(int[] nums1, int[] nums2) {

        Set hashSet = new HashSet();
        Map<String, Integer> map = new HashMap();
        map.put("len", 0);
        int[] re = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        Arrays.stream(nums1).forEach((item) ->
                hashSet.add(item)
        );
        Arrays.stream(nums2).distinct().forEach(item ->
                {
                    int index = 0;
                    if (hashSet.contains(item)) {
                        re[map.get("len")] = item;
                        index++;
                    }
                    map.put("len", map.get("len") + index);
                }
        );
        //将re中初始化为0的位置去除
        return Arrays.copyOf(re, map.get("len"));
    }

    /**
     * @Description 快乐数
     * @author gexx
     * @Date 2020/3/1
     **/
    public static boolean isHappy(int n) {
        // Write your code here
        if(n==1){
            return true;
        }
        if(n<1){
            return false;
        }
        int count=0;
        while(n!=1){
            String s=n+"";
            char []arr=s.toCharArray();
            int sum=0;
            for(int i=0;i<arr.length;i++){
                sum+=Integer.parseInt(arr[i]+"")*Integer.parseInt(arr[i]+"");
            }
            n=sum;
            count++;
            if(count>1000){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }
}