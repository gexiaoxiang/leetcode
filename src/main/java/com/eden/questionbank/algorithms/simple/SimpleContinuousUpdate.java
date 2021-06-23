package com.eden.questionbank.algorithms.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

    public static void main(String[] args) {
        secondHighest("ck077");
        HashSet h=new HashSet();
    }

}
