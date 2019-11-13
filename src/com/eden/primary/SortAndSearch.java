package com.eden.primary;

import java.util.Arrays;

/**
 * @Description: 排序和搜索
 * @Author gexx
 * @Date 2019/11/11
 * @Version V1.0
 **/
public class SortAndSearch {

    /**
     * @Description: 合并两个有序数组
     * @Param: [nums1, m, nums2, n]
     * @Return: void
     * @Author: gexx
     * @Date: 2019/11/11
     **/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            //前两个判断要放在前面，防止空指针异常
            if (i < 0) {
                nums1[index--] = nums2[j--];
            } else if (j < 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] > nums2[j] && i >= 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] <= nums2[j] && j >= 0) {
                nums1[index--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }




    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int n = 3;
        int nums2[] = {2, 5, 6};
        merge(nums1, m, nums2, n);

    }
}
