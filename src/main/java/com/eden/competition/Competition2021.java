package com.eden.competition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Competition2021 {

    /**
     * @Descriptionv5661. 替换隐藏数字得到的最晚时间
     * @author gexx
     * @Date 2021/1/24
     **/
    public static String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?' && arr[1] == '?') {
            arr[0] = '2';
            arr[1] = '3';
        } else if (arr[0] == '?') {
            if (arr[1] <= '3') {
                arr[0] = '2';
            } else {
                arr[0] = '1';
            }
        } else if (arr[1] == '?') {
            if (arr[0] <= '1') {
                arr[1] = '9';
            } else {
                arr[1] = '3';
            }
        }

        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);


    }


    /**
     * @Description 5654. 盒子中小球的最大数量
     * @author gexx
     * @Date 2021/1/31
     **/
    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> cap = new HashMap();
        for (int i = lowLimit; i <= highLimit; i++) {
            cap.put(sum(i), cap.getOrDefault(sum(i), 0) + 1);
        }
        int maxNum = 0;
        Iterator iterator = cap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            maxNum = Math.max(maxNum, cap.get(key));
        }


        return maxNum;
    }

    public static int sum(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n /= 10;
        }
        sum += n;
        return sum;
    }

    /**
     * @Description 5657. 唯一元素的和
     * @Author gexx
     * @Date 2021/2/6
     **/
    public static int sumOfUnique(int[] nums) {
        int fill[] = new int[101];

        for (int i = 0; i < nums.length; i++) {
            fill[nums[i]] = fill[nums[i]] + 1;
        }
        int sum = 0;
        for (int i = 0; i < fill.length; i++) {
            if (fill[i] == 1) {
                sum += i;
            }
        }

        return sum;

    }

    /**
     * @Description: 5685. 交替合并字符串
     * @Author: gexx
     * @Date: 2021/2/21
     **/
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int word1Length = word1.length();
        int word2Length = word2.length();
        int length;
        String word;
        if (word1Length > word2Length) {
            length = word2.length();
            word = word1;
        } else {
            length = word1.length();
            word = word2;
        }

        for (int i = 0; i < length; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(word.substring(length));
        return sb.toString();
    }


    /**
     * @Description 5689. 统计匹配检索规则的物品数量
     * @author gexx
     * @Date 2021/2/28
     **/
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) {
                count++;
            } else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) {
                count++;
            } else if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) {
                count++;
            }


        }

        return count;
    }

    public static void main(String[] args) {
        sumOfUnique(new int[]{1, 2, 3, 2});

        System.out.println(countBalls(1, 10));
        System.out.println(maximumTime("2?:?0"));
    }
}
