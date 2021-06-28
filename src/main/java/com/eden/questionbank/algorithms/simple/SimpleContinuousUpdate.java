package com.eden.questionbank.algorithms.simple;

import java.util.*;

/**
 * @Description: 简单题持续更新
 * @Author gexx
 * @Date 2021/6/18
 * @Version V1.0
 **/
public class SimpleContinuousUpdate {

    /**
     * @Description: 495. 提莫攻击
     * @Author: gexx
     * @Date: 2021/6/18
     **/
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int n = timeSeries.length;
        if (n == 0) return 0;

        int total = 0;
        for (int i = 0; i < n - 1; ++i)
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        return total + duration;
    }

    /**
     * @Description: 1796. 字符串中第二大的数字
     * @Author: gexx
     * @Date: 2021/6/18
     **/
    public static int secondHighest(String s) {
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                list.add(Integer.valueOf(String.valueOf(c)));
            }
        }

        int[] re = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            re[i] = list.get(i);
        }
        Arrays.sort(re);
        int[] ints = Arrays.stream(re).distinct().toArray();
        if (ints.length <= 1) return -1;
        if (ints[ints.length - 1] > ints[ints.length - 2]) {
            return ints[ints.length - 2];
        }


        return -1;
    }

    /**
     * @Description: 1800. 最大升序子数组和
     * @Author: gexx
     * @Date: 2021/6/24
     **/
    public int maxAscendingSum(int[] nums) {

        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
                max = Math.max(max, sum);
            } else {
                sum = nums[i];
            }
        }
        return max;
    }

    /**
     * @Description: 1805. 字符串中不同整数的数目
     * @Author: gexx
     * @Date: 2021/6/28
     **/
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                //去除前导0
                while (i < word.length() && word.charAt(i) == '0') {
                    i++;
                }
                while (i < word.length() && Character.isDigit(word.charAt(i))) {
                    sb.append(word.charAt(i));
                    i++;
                }
                i -= 1;
                set.add(sb.toString());
            }
        }
        return set.size();

    }

    /**
     * @Description: 1812. 判断国际象棋棋盘中一个格子的颜色
     * @Author: gexx
     * @Date: 2021/6/28
     **/
    public static boolean squareIsWhite(String coordinates) {

        return ((coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0);
    }

    public static void main(String[] args) {
        secondHighest("ck077");
        HashSet h = new HashSet();
        squareIsWhite("w");
    }

}
