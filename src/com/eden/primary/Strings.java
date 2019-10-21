package com.eden.primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @Description: 字符串相关算法
 * @Author gexx
 * @Date 2019/10/14
 * @Version V1.0
 **/
public class Strings {

    /**
     * @Description: 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * @Param: [s]
     * @Return: void
     * @Author: gexx
     * @Date: 2019/10/14
     **/
    public static void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char mid = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = mid;
        }
        System.out.println(s);

    }

    /**
     * @Description: 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * @Param: [x]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/10/15
     **/
    public static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuffer stringBuffer = new StringBuffer(s.length());
        stringBuffer.append(x);
        if (x < 0) {
            stringBuffer.deleteCharAt(0);
            stringBuffer.reverse();
            stringBuffer.insert(0, '-');
        } else {
            stringBuffer.reverse();
        }
        long sss = Long.valueOf(stringBuffer.toString());

        if (sss >= Integer.MAX_VALUE ||
                sss <= Integer.MIN_VALUE) {
            return 0;
        }
        Integer re = Integer.valueOf(stringBuffer.toString());

        return re;
    }

    /**
     * @Description: 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * 您可以假定该字符串只包含小写字母
     * @Param: [s]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/10/16
     **/
    public static int firstUniqChar(String s) {

        if (null == s || 0 == s.length()) return -1;
        int[] a = new int[26];
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            a[ss[i] - 'a']++;
        }
        for (int i = 0; i < ss.length; i++) {
            if (a[ss[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @Description: 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @Param: [s, t]
     * @Return: boolean
     * @Author: gexx
     * @Date: 2019/10/17
     **/
    public static boolean isAnagram(String s, String t) {
        String[] splitS = s.split("");
        String[] splitT = t.split("");
        if (splitS.length != splitT.length) {
            return false;
        }
        Arrays.sort(splitS);
        Arrays.sort(splitT);
        for (int i = 0; i < splitS.length; i++) {
            if (!splitS[i].equals(splitT[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * @Description: 验证回文字符串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     * @Param: [s]
     * @Return: boolean
     * @Author: gexx
     * @Date: 2019/10/18
     **/
    public static boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    /**
     * @Description: 字符串转换整数 (atoi)
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * @Param: [str]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/10/21
     **/
    public static int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n || !((str.charAt(i) == '+') || (str.charAt(i) == '-') || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (str.charAt(i) == '-') {
            stringBuilder.append('-');
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        if (i == n || !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            return 0;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            stringBuilder.append(str.charAt(i));
            i++;
        }
        try {
            return Integer.valueOf(stringBuilder.toString());
        } catch (Exception e) {
            if (stringBuilder.substring(0, 1).equals("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }


    }

    public static void main(String[] args) {
        //反转字符串
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        //整数反转
        //int x=9646324351;
        int x = 123;
        int reverse = reverse(x);
        System.out.println(reverse);
        //字符串中的第一个唯一字符
        String ss = "loveleetcode";
        System.out.println(firstUniqChar(ss));
        //有效的字母异位词
        String s1 = "aba";
        String t1 = "aab";
        System.out.println(isAnagram(s1, t1));
        //验证回文字符串
        String palindromeStr = "A man, a plan, a canal: Panama";
//        String palindromeStr = "race a car";
        System.out.println(isPalindrome(palindromeStr));
        //字符串转换整数
        String myAtoi = "";
        System.out.println(myAtoi(myAtoi));

    }

}
