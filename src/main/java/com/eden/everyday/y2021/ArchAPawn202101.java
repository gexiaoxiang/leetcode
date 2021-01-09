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

    /**
     * @Description 123. 买卖股票的最佳时机 III
     * @Author gexx
     * @Date 2021/1/9
     **/
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;

    }

    public static void main(String[] args) {
        maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(Arrays.toString("12.22".split("\\|")));
        rotate(new int[]{
                1, 2, 3, 4, 5, 6, 7
        }, 3);
    }
}
