package com.eden.everyday.y2021;

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


    public static void main(String[] args) {
        int fib = fib(2);
        System.out.println(fib);
    }
}
