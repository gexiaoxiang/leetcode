package com.eden.questionbank.algorithms.simple;

/**
 * @Description: 简单2  page2 size 100
 * @Author: gexx
 * @Date: 2020/7/6
 **/
public class Simple02 {

    /**
     * @Description: 数字转换为十六进制数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static String toHex(int num) {
        StringBuffer buffer = new StringBuffer();
        char[] arr = "0123456789abcdef".toCharArray();
        if (num == 0) return "0";
        while (num != 0) {
            int tmp = num & 15;
            buffer.append(arr[tmp]);
            num = num >>> 4;
        }

        return buffer.reverse().toString();


    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
    }
}
