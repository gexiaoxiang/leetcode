package com.eden.primary;

/**
 * @Description: 动态规划
 * @Author gexx
 * @Date 2019/11/13
 * @Version V1.0
 **/
public class DynamicProgramming {
    /**
     * @Description: 爬楼梯
     * @Param: [n]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/13
     **/
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }
        int cur = 2;//到达当前阶梯的方法数，从2开始，与for循环i对应
        int pre = 1;//到达前一个阶梯的方法数
        for (int i = 2; i < n; i++) {
            int next = pre + cur;//到达后一个阶梯的方法数
            pre = cur;
            cur = next;//最后一躺循环i=n-1;next=dp(i-1)+dp(i)赋值给cur，然后i++,i=n跳出循环

        }
        return cur;


    }

    /**
     * @Description: 买卖股票的最佳时机
     * @Param: [prices]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/14
     **/
    public static int maxProfit(int[] prices) {

        int max = 0;
        if (prices.length < 2) {
            return max;
        }
        if (prices.length == 2 && prices[1] - prices[0] > 0) {
            return prices[1] - prices[0];
        }
        for (int in = 0; in < prices.length - 1; in++) {
            for (int out = in + 1; out < prices.length; out++) {
                int difference = prices[out] - prices[in];
                if (max < difference) {
                    max = difference;
                }
            }
        }

        return max;
    }

    /**
     * @Description: 最大子序和
     * @Param: [nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/15
     **/
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    /**
     * @Description: 打家劫舍
     * @Param: [nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/18
     **/
    public static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;


    }

    public static void main(String[] args) {
        int prices[] = {1, 2, 4};
        int max = maxProfit(prices);
        System.out.println(max);

        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);

        int num[]={2,7,9,3,1};
        int rob = rob(num);
        System.out.println(rob);

    }
}
