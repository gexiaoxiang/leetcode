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

    public int sumBase(int n, int k) {
        String s = Integer.toString(n, k);
        char[] chars = s.toCharArray();
        int count = 0;
        for (char ch : chars) {
            count += ch - '0';
        }

        return count;
    }

    /**
     * @Description: 1848. 到目标元素的最小距离
     * @Author: gexx
     * @Date: 2021/7/16
     **/
    public int getMinDistance(int[] nums, int target, int start) {
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minAbs = Math.min(minAbs, Math.abs(i - start));
            }

        }

        return minAbs;
    }

    /**
     * @Description: 1854. 人口最多的年份
     * @Author: gexx
     * @Date: 2021/7/16
     **/
    public int maximumPopulation(int[][] logs) {
        int[] d = new int[110];
        for (int[] log : logs) {     //遍历每个人的出生和死亡年份
            d[log[0] - 1950] += 1;  //出生年份人数+1
            d[log[1] - 1950] -= 1;  //死亡年份人数-1
        }
        int s = 0, res = 0, cnt = 0;
        for (int i = 0; i <= 100; i++) {
            s += d[i];      //s是记录每一年的存活人数
            if (s > cnt) {
                cnt = s;
                res = i;
            }
        }
        return res + 1950;
    }

    /**
     * @Description: 1859. 将句子排序
     * @Author: gexx
     * @Date: 2021/7/21
     **/
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= words.length; i++) {
            for (String word : words) {
                if (word.indexOf(i + "") > -1) {
                    sb.append(word.substring(0, word.length() - 1)).append(" ");
                }
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }


    int res = 0;

    /**
     * 1863. 找出所有子集的异或总和再求和
     *
     * @param nums
     * @return
     */
    public int subsetXORSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        dfs(nums, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int i, int xor_sum) {
        if (i == nums.length) {
            res += xor_sum;
            return;
        }
        //当前位置要
        dfs(nums, i + 1, xor_sum ^ nums[i]);
        //当前位置不要
        dfs(nums, i + 1, xor_sum);
    }

    public static void main(String[] args) {
        sortSentence("is2 sentence4 This1 a3");
        replaceDigits("a1c1e1");
        secondHighest("ck077");
        HashSet h = new HashSet();
        arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41});

    }

}








