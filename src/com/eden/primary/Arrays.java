package com.eden.primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 数组相关算法
 * @author: gexx
 * @date: 2019/9/25
 **/
public class Arrays {
    public static void main(String[] args) {

        //交集
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(java.util.Arrays.toString(intersect));
    }

    /**
     * @Description: 给定两个数组，编写一个函数来计算它们的交集
     * 示例 1:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * @Param: [nums1, nums2]
     * @return: int[]
     * @User: gexx
     * @Date: 2019/9/26
     */
     public static int[] intersect(int[] nums1, int[] nums2) {
        //将数组排序
        java.util.Arrays.sort(nums1);
        java.util.Arrays.sort(nums2);
        List<Integer> middleList = new ArrayList<Integer>();

        for (int x = 0, y = 0; x < nums1.length && y < nums2.length; ) {
            if (nums1[x] == nums2[y]) {
                middleList.add(nums1[x]);
                x++;
                y++;
            } else if (nums1[x] > nums2[y]) {
                y++;
            }else {
                x++;
            }

        }
        int[] finalArray = new int[middleList.size()];
        for (int i = 0; i < middleList.size(); i++) {
            finalArray[i] = middleList.get(i);
        }
        return finalArray;
    }
}