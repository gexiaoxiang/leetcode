package com.eden.explore.datastructure.arrayandstring;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 数组简介
 * @Author gexx
 * @Date 2019/12/20
 * @Version V1.0
 **/
public class Introduction2Arrays {
    /**
     * @Description: 寻找数组的中心索引
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * @Param: [nums]
     * @Return: in
     * @Author: gexx
     * @Date: 2019/12/20
     **/
    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    /**
     * @Description: 至少是其他数字两倍的最大数
     * @Param: [nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/12/23
     **/

    public static int dominantIndex(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        if(nums.length==1) return 0;
        int max = clone[clone.length - 1];
        int maxL = clone[clone.length - 2];
        if (maxL == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (max == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
        if (max / maxL < 2) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = {-1, -1, 0, 1, 1, 0};
        int nums2[] = {1, 2, 3};
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
        int nums3[] = {0, 0, 0, 1};
        System.out.println(dominantIndex(nums3));
    }
}
