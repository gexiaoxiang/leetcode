package com.eden.everyday;

/**
 * @Description: 每日一题
 * @Author gexx
 * @Date 2020/7/17
 * @Version V1.0
 **/
public class ArchAPawn202007 {
    /**
     * @Description: 搜索插入位置
     * @Author: gexx
     * @Date: 2020/7/17
     **/
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i] && i < nums.length - 1 && target < nums[i + 1]) {
                return i + 1;
            }
        }

        return 1;
    }
}
