package com.eden.explore.interviewclassic.primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 数学
 * @Author gexx
 * @Date 2019/11/26
 * @Version V1.0
 **/
public class Math {
    /**
     * @Description: Fizz Buzz
     * @Param: [n]
     * @Return: java.util.List<java.lang.String>
     * @Author: gexx
     * @Date: 2019/11/26
     **/
    public static List<String> fizzBuzz(int n) {
        List fizzs = new ArrayList<String>(n);
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzs.add("FizzBuzz");
            } else if (i % 3 == 0) {
                fizzs.add("Fizz");
            } else if (i % 5 == 0) {
                fizzs.add("Buzz");
            } else {
                fizzs.add(Integer.toString(i));
            }
        }

        return fizzs;
    }

    /**
     * @Description: 计数质数
     * @Param: [n]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/27
     **/
    public static int countPrimes(int n) {

        int countPrimes = 0;
        if (n <= 1) {
            return countPrimes;
        }
        //默认为false
        boolean[] isPrime = new boolean[n];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        //统计质数个数
        for (boolean b : isPrime) {
            if (!b) {
                countPrimes++;
            }
        }

        return countPrimes;
    }

    /**
     * @Description: 3的幂
     * @Param: [n]
     * @Return: boolean
     * @Author: gexx
     * @Date: 2019/11/28
     **/
    public boolean isPowerOfThree(int n) {

        return (n > 0 && 1162261467 % n == 0);
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
        int n1 = 10;
        System.out.println(countPrimes(n1));
    }
}
