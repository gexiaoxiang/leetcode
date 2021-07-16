package com.eden.everyday.y2021;


import java.util.Arrays;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/6/5
 * @Version V1.0
 **/
public class ArchAPawn202107 {
    /**
     * @Description: 1846. 减小和重新排列数组后的最大元素
     * @Author: gexx
     * @Date: 2021/7/15
     **/
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    /**
     * @Description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * @Author: gexx
     * @Date: 2021/7/16
     **/
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length - 1;
        int l = 0, r = n;
        // 右边界
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (nums[l] != target) return 0; // 没有找到直接返回0
        int right = r;
        // 左边界
        l = 0;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? right - l + 1 : 0;

    }
}
