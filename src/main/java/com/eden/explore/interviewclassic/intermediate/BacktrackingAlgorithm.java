package com.eden.explore.interviewclassic.intermediate;

import java.util.*;

/**
 * @Description: 回溯算法
 * @Author gexx
 * @Date 2020/5/9
 * @Version V1.0
 **/
public class BacktrackingAlgorithm {
    /**
     * @Description: 电话号码的字母组合
     * @Author: gexx
     * @Date: 2020/5/9
     **/
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        Map<Character, String> dictionaries = new HashMap();
        dictionaries.put('2', "abc");
        dictionaries.put('3', "def");
        dictionaries.put('4', "ghi");
        dictionaries.put('5', "jkl");
        dictionaries.put('6', "mno");
        dictionaries.put('7', "pqrs");
        dictionaries.put('8', "tuv");
        dictionaries.put('9', "wxyz");

        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : chars) {
            List<String> tmpList = new ArrayList<>();
            String sufStr = dictionaries.get(c);
            for (String str : result) {
                for (Character tmpC : sufStr.toCharArray()) {
                    String tmpStr = str + tmpC;
                    tmpList.add(tmpStr);
                }
            }
            result = tmpList;
        }

        return result;

    }

    /**
     * @Description: 括号生成
     * @Author: gexx
     * @Date: 2020/5/9
     **/
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    /**
     * @Description: 全排列
     * @Author: gexx
     * @Date: 2020/5/14
     **/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        huisu(nums, l, result);
        return result;
    }

    public static void huisu(int[] nums, List<Integer> l, List<List<Integer>> result) {
        if (l.size() == nums.length) {
            //指向新的一片地址空间使其变成不在跟随l改变而改变
            result.add(new ArrayList<Integer>(l));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                //判断
                if (l.contains(nums[i])) continue;
                l.add(nums[i]);
                huisu(nums, l, result);
                //退回一格
                l.remove(l.size() - 1);
            }
        }
    }

    /**
     * @Description: 子集
     * @Author: gexx
     * @Date: 2020/6/3
     **/

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }

    /**
     * @Description: 单词搜索
     * @Author: gexx
     * @Date: 2020/6/3
     **/

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int start, boolean[][] visited) {
        //首先确立剪枝条件
        //注意下标的特点不能够是word.length()-1
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(start) != board[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(board, word, i, j + 1, start + 1, visited) || dfs(board, word, i, j - 1, start + 1, visited) || dfs(board, word, i - 1, j, start + 1, visited) || dfs(board, word, i + 1, j, start + 1, visited)) {
            return true;
        } else {
            //回溯
            visited[i][j] = false;
            return false;
        }
    }

    /**
     * @Description: 合并区间
     * @Author: gexx
     * @Date: 2020/6/4
     **/

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;

        int cnt = 0; // 合并次数
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null; // 清空前者
                    cnt++;
                    break;
                }
            }
        }

        int[][] res = new int[len - cnt][2]; // len - cnt 合并后个数
        int ri = 0;
        for (int[] pair : intervals) {
            if (pair != null) res[ri++] = pair;
        }
        return res;


    }

    /**
     * @Description: 搜索二维矩阵 II
     * @Author: gexx
     * @Date: 2020/6/4
     **/
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = matrix.length;
        if (l == 0) return false;
        int w = matrix[0].length;
        if (w == 0) return false;

        if (matrix[0][0] > target || matrix[l - 1][w - 1] < target) return false;
        for (int m = 0; m < matrix.length; m++) {
            if (matrix[m][w - 1] < target) continue;
            if (matrix[m][0] > target) return false;
            for (int n = 0; n < matrix[0].length; n++) {
                if (target == matrix[m][n]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        int[] b = {1, 2, 3};
        permute(b);
        int[] nums = {1, 2, 3};
        subsets(nums);


        int arr1[] = {1, 3};
        int arr2[] = {2, 6};
        int arr3[] = {8, 10};
        int arr4[] = {15, 18};

        int arr[][] = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(arr, 5));


    }
}
