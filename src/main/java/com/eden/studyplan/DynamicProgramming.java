package com.eden.studyplan;

/**
 * @Description: 动态规划 20天
 * @Author gexx
 * @Date 2021/7/28
 * @Version V1.0
 **/
public class DynamicProgramming {
    /**
     * @Description: 509. 斐波那契数
     * @Author: gexx
     * @Date: 2021/7/28
     **/
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * @Description: 1137. 第 N 个泰波那契数
     * @Author: gexx
     * @Date: 2021/7/28
     **/
    public int tribonacci(int n) {
        if (n == 0) {
            return n;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;
    }

    /**
     * @Description: 70. 爬楼梯
     * @Author: gexx
     * @Date: 2021/7/29
     **/
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 198. 打家劫舍
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    /**
     * 55. 跳跃游戏
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);

        }
        return true;
    }
}
