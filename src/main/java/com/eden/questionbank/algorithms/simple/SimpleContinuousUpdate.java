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

    /**
     * @Description: 1816. 截断句子
     * @Author: gexx
     * @Date: 2021/7/8
     **/
    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        int len = s1.length >= k ? k : s1.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(s1[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * @Description: 1822. 数组元素积的符号
     * @Author: gexx
     * @Date: 2021/7/8
     **/
    public static int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                negativeCount++;
            }

        }
        if (negativeCount % 2 == 0) {
            return 1;
        } else {
            return -1;
        }


    }

    /**
     * @Description: 1827. 最少操作使数组递增
     * @Author: gexx
     * @Date: 2021/7/14
     **/
    public int minOperations(int[] nums) {
        int count = 0;
        if (nums.length == 1) {
            return count;
        }
        for (int i = 1; i <= nums.length; i++) {
            while (nums[i] < nums[i - 1]) {
                nums[i]++;
                count++;
            }
        }

        return count;
    }

    /**
     * @Description: 1832. 判断句子是否为全字母句
     * @Author: gexx
     * @Date: 2021/7/14
     **/
    public boolean checkIfPangram(String sentence) {

        if (sentence.length() < 26) {
            return false;
        }
        char[] chars = sentence.toCharArray();
        Set set = new HashSet();
        for (char aChar : chars) {

            set.add(aChar);
            if (set.size() == 26) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description: 1844. 将所有数字用字符替换
     * @Author: gexx
     * @Date: 2021/7/15
     **/
    public static String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (i % 2 == 0) {
                sb.append(chars[i]);
            } else {
                sb.append((char) (chars[i - 1] + Integer.valueOf(String.valueOf(chars[i]))));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        replaceDigits("a1c1e1");
        secondHighest("ck077");
        HashSet h = new HashSet();
        arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41});

    }

}
