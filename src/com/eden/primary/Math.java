package com.eden.primary;

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

    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
    }
}
