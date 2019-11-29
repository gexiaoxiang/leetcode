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


    /**
     * @Description: 罗马数字转整数
     * @Param: [s]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/29
     **/
    public int romanToInt(String roman) {
        int count = 0;
        if (roman.indexOf("IV") > -1) {
            count += 4;
            roman = roman.replace("IV", "");
        }
        if (roman.indexOf("IX") > -1) {
            count += 9;
            roman = roman.replace("IX", "");
        }
        if (roman.indexOf("XL") > -1) {
            count += 40;
            roman = roman.replace("XL", "");
        }
        if (roman.indexOf("XC") > -1) {
            count += 90;
            roman = roman.replace("XC", "");
        }
        if (roman.indexOf("CD") > -1) {
            count += 400;
            roman = roman.replace("CD", "");
        }
        if (roman.indexOf("CM") > -1) {
            count += 900;
            roman = roman.replace("CM", "");
        }
        String[] romans = roman.split("");
        for (int i = 0; i < romans.length; i++) {
            if ("I".equals(romans[i])) {
                count += 1;
                romans[i] = "0";
            } else if ("V".equals(romans[i])) {
                count += 5;
                romans[i] = "0";
            } else if ("X".equals(romans[i])) {
                count += 10;
                romans[i] = "0";
            } else if ("L".equals(romans[i])) {
                count += 50;
                romans[i] = "0";
            } else if ("C".equals(romans[i])) {
                count += 100;
                romans[i] = "0";
            } else if ("D".equals(romans[i])) {
                count += 500;
                romans[i] = "0";
            } else if ("M".equals(romans[i])) {
                count += 1000;
                romans[i] = "0";
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
        int n1 = 10;
        System.out.println(countPrimes(n1));
    }
}
