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
     * @Description: 189. 旋转数组
     * @Author: gexx
     * @Date: 2021/1/8
     **/
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("12.22".split("\\|")));
        rotate(new int[]{
                1, 2, 3, 4, 5, 6, 7
        }, 3);
    }
}
