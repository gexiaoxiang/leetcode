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
}
