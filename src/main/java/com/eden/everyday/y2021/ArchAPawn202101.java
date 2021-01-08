package com.eden.everyday.y2021;

import java.util.Arrays;

/**
 * @Description: 每日一题
 * @Author: gexx
 * @Date: 2021/1/4
 **/
public class ArchAPawn202101 {
    /**
     * @Description: 斐波那契数
     * @Author: gexx
     * @Date: 2021/1/4
     **/
    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * @Description: 977. 有序数组的平方
     * @Author: gexx
     * @Date: 2021/1/8
     **/
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("12.22".split("\\|")));
    }
}
