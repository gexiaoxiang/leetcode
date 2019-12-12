package com.eden.explore.interviewclassic.intermediate;

import java.util.*;

/**
 * @Description: 数组和字符串
 * @Author gexx
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class ArrayAndString {
    /**
     * @Description: 三数之和
     * @Param: [nums]
     * @Return: java.util.List<java.util.List                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Integer>>
     * @Author: gexx
     * @Date: 2019/12/6
     **/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = nums.length - 1;
            int target = 0 - nums[i];
            int k = i + 1;
            while (k < j) {
                if (nums[k] + nums[j] == target) {
                    List<Integer> item = Arrays.asList(nums[i], nums[k], nums[j]);
                    result.add(item);
                    while (k < j && nums[k] == nums[k + 1]) k++;
                    while (k < j && nums[j] == nums[j - 1]) j--;
                    k++;
                    j--;
                } else if (nums[k] + nums[j] < target) {
                    k++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }


    /**
     * @Description: 矩阵置零
     * @Param: [matrix]
     * @Return: void
     * @Author: gexx
     * @Date: 2019/12/6
     **/

    public static void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * @Description: 字谜分组
     * @Param: [strs]
     * @Return: java.util.List<java.util.List                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.String>>
     * @Author: gexx
     * @Date: 2019/12/10
     **/
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<List<String>> res = new ArrayList<>();
        int i = 0;
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (!hashMap.containsKey(str)) {
                ArrayList<String> list = new ArrayList<>();
                hashMap.put(str, i++);
                list.add(s);
                res.add(list);
            } else {
                res.get(hashMap.get(str)).add(s);
            }
        }
        return res;

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end = 0, start = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }

        }
        return res;

    }

    /**
     * @Description: 最长回文子串
     * @Param: [s]
     * @Return: java.lang.String
     * @Author: gexx
     * @Date: 2019/12/12
     **/
    public static String longestPalindrome(String string) {

        if (null == string || string.length() < 1) return "";
        int start = 0, end = 0;
        int num1, num2, len;
        for (int i = 0; i < string.length(); i++) {
            num1 = getMaxLength(string, i, i);
            num2 = getMaxLength(string, i, i + 1);
            len = Math.max(num1, num2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return string.substring(start, end + 1);
    }

    public static int getMaxLength(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int[][] s = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(s);
        System.out.println(System.currentTimeMillis() - l);
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(str);
        String ss = "pwwkew";
        System.out.println(lengthOfLongestSubstring(ss));

    }
}
