package com.eden.everyday.y2020;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 每日一题
 * @Author gexx
 * @Date 2020/7/17
 * @Version V1.0
 **/
public class ArchAPawn202007 {
    /**
     * @Description: 搜索插入位置
     * @Author: gexx
     * @Date: 2020/7/17
     **/
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i] && i < nums.length - 1 && target < nums[i + 1]) {
                return i + 1;
            }
        }

        return 1;
    }

    /**
     * @Description 交错字符串
     * @Author gexx
     * @Date 2020/7/18
     **/
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[] f = new boolean[m + 1];

        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[m];
    }

    /**
     * @Description 戳气球
     * @Author gexx
     * @Date 2020/7/19
     **/
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

    /**
     * @Description: 两数之和 II - 输入有序数组
     * @Author: gexx
     * @Date: 2020/7/20
     **/
    public static int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            }
        }
        return ret;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @Description: 不同的二叉搜索树 II
     * @Author: gexx
     * @Date: 2020/7/21
     **/
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    /**
     * @Description: 剑指 Offer 11. 旋转数组的最小数字
     * @Author: gexx
     * @Date: 2020/7/22
     **/
    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            min = Math.min(min, number);
        }
        return min;
    }

    /**
     * @Description: 机器人能否返回原点
     * @Author: gexx
     * @Date: 2020/7/22
     **/
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                x++;
            } else if (move == 'D') {
                x--;
            } else if (move == 'R') {
                y++;
            } else {
                y--;
            }
        }
        return x == 0 && y == 0;
    }

    /**
     * @Description: 最小路径和
     * @Author: gexx
     * @Date: 2020/7/23
     **/
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }


    public static void main(String[] args) {
        twoSum(new int[]{-1, 0}, -1);
    }
}
