package com.eden.questionbank.algorithms.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * @Description: 最长回文串
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

    /**
     * @Description: 第三大的数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        List list = new ArrayList<>();
        list.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] != nums[i]) {
                list.add(nums[i]);
            }
        }
        if (list.size() < 3) {
            return (int) list.get(0);
        }

        return (int) list.get(2);
    }

    /**
     * @Description: 字符串相加
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();

    }

    /**
     * @Description: 字符串中的单词数
     * @Author: gexx
     * @Date: 2020/7/6
     **/
    public static int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }


    public static void main(String[] args) {
        System.out.println(addStrings("1234", "1234"));
        System.out.println(toHex(26));
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(thirdMax(new int[]{1, 1, 2}));
        System.out.println(countSegments(""));
    }
}
