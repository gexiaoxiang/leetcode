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

    public static void main(String[] args) {
        int prices[] = {1, 2, 4};
        int max = maxProfit(prices);
        System.out.println(max);

    }
}
