package com.eden.explore.arrayalgorithm;

/**
 * @Description: 数组类算法
 * @Author gexx
 * @Date 2020/4/29
 * @Version V1.0
 **/
public class ArrayAlgorithm {
    /**
     * @Description: 删除排序数组中的重复项 II
     * @Author: gexx
     * @Date: 2020/4/30
     **/
    public int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int i = 1;
        for (int j = i + 1; j < nums.length; ++j) {
            if (nums[i] != nums[j] || (nums[j] == nums[i] && nums[i - 1] != nums[j])) {
                nums[i + 1] = nums[j];
                ++i;
            }
        }
        return i + 1;
    }

}
