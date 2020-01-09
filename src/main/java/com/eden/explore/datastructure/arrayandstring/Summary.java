package com.eden.explore.datastructure.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 小结
 * @Author gexx
 * @Date 2020/1/9
 * @Version V1.0
 **/
public class Summary {
    /**
     * @Description: 杨辉三角 II
     * @Param: [rowIndex]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: gexx
     * @Date: 2020/1/8
     **/
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<Integer>();
        long nk = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return res;
    }

    /**
     * @Description: 翻转字符串里的单词
     * @Param: [s]
     * @Return: java.lang.String
     * @Author: gexx
     * @Date: 2020/1/9
     **/
    public static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = split.length - 1; i >= 0; i--) {
            String ss = split[i];
            if (!"".equals(ss)) {
                sb.append(" ").append(ss);
            }
        }
        return sb.toString().trim();
    }

    /**
     * @Description: 反转字符串中的单词 III
     * @Param: [s]
     * @Return: java.lang.String
     * @Author: gexx
     * @Date: 2020/1/9
     **/
    public static String reverseWordsIII(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder sbin = new StringBuilder();
            sb.append(sbin.append(strings[i]).reverse().toString() + " ");
        }
        String trim = sb.toString().trim();
        System.out.println(trim);
        return trim;
    }

    public static void main(String[] args) {
        reverseWordsIII("Let's take LeetCode contest");
    }
}
