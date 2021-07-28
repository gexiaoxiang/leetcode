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

}
