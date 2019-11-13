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

        if(n<=2){
            return n;
        }
        int cur=2;//到达当前阶梯的方法数，从2开始，与for循环i对应
        int pre=1;//到达前一个阶梯的方法数
        for(int i=2;i<n;i++){
            int next=pre+cur;//到达后一个阶梯的方法数
            pre=cur;
            cur=next;//最后一躺循环i=n-1;next=dp(i-1)+dp(i)赋值给cur，然后i++,i=n跳出循环

        }
        return cur;


    }
}
