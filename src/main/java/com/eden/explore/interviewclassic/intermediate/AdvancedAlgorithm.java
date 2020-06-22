package com.eden.explore.interviewclassic.intermediate;

/**
 * @Description: Advanced algorithm
 * @Author gexx
 * @Date 2020/6/22
 * @Version V1.0
 **/
public class AdvancedAlgorithm {
    /**
     * @Description: 除自身以外数组的乘积
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int n1[] = new int[n];
        int n2[] = new int[n];
        n1[0] = 1;
        n2[0] = 1;
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            n1[i] = nums[i - 1] * n1[i - 1];
            n2[i] = nums[n - i] * n2[i - 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = n1[i] * n2[n - i - 1];
        }
        return result;

    }
}
