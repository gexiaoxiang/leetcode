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

    /**
     * @Description: 跳跃游戏
     * @Author: gexx
     * @Date: 2020/6/4
     **/
    public boolean canJump(int[] nums) {

        int index = 0;//当前位置
        int discount = 0;//可以达到的最远距离
        for (int i = 0; i < nums.length - 1 && index <= discount; i++) {
            discount = Math.max(discount, index + nums[i]);
            index++;
        }
        return discount >= nums.length - 1;
    }

    /**
     * @Description: 不同路径
     * @Author: gexx
     * @Date: 2020/6/4
     **/
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        return arr[n - 1][m - 1];
    }

    /**
     * @Description: 零钱兑换
     * @Author: gexx
     * @Date: 2020/6/4
     **/
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];  //dp[i]表示达到i用的最少硬币数  默认=初始化全为0
        for (int i = 1; i <= amount; i++) {  //目标为0 的不用计算
            dp[i] = 999999;   //此处不能用int的最大值，最大值+1 会溢出变为最小值
            for (int coin : coins) {
                if (i - coin >= 0) dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == 999999 ? -1 : dp[amount];
    }


    /**
     * @Description: Longest Increasing Subsequence
     * @Author: gexx
     * @Date: 2020/6/4
     **/
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 状态的定义是：以 i 结尾的最长上升子序列的长度
        // 状态转移方程：之前比最后那个数字小的最长上升子序列的长度 + 1
        int[] dp = new int[len];
        Arrays.fill(dp, 1); // 如果只有 1 个元素，那么这个元素自己就构成了最长上升子序列，所以设置为 1 是合理的
        for (int i = 1; i < len; i++) { // 从第 2 个元素开始，逐个写出 dp 数组的元素的值
            int curVal = nums[i];
            for (int j = 0; j < i; j++) { // 找出比当前元素小的哪些元素的最小值
                if (curVal > nums[j]) {
                    dp[i] = Integer.max(dp[j] + 1, dp[i]);
                }
            }
        }
        // 最后要全部走一遍，看最大值
        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Integer.max(res, dp[i]);
        }
        return res;
    }

    /**
     * @Description: 多数元素
     * @Author: gexx
     * @Date: 2020/6/4
     **/
    public static int majorityElement(int[] nums) {
        return backtrack(nums, nums[0], 0);
    }

    private static int backtrack(int[] nums, int current, int start) {
        int count = 1;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == current) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return backtrack(nums, nums[i], i + 1);
            }
        }
        return current;
    }

    /**
     * @Description: 任务调度器
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int maxVal = count[25] - 1, idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idleSlots -= Math.min(count[i], maxVal);
        }
        if (idleSlots > 0) {
            return idleSlots + tasks.length;
        } else {
            return tasks.length;
        }

    }

    public static void main(String[] args) {
        generateParenthesis(3);
        int[] b = {1, 2, 3};
        permute(b);
        int[] nums = {1, 2, 3};
        subsets(nums);

        int arr[][] = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(arr, 5));
        int arr1[] = {2, 2, 1, 1, 1, 2, 2};
        majorityElement(arr1);

        System.out.println("lol".indexOf(""));
    }
}
