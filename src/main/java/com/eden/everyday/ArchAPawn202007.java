package com.eden.everyday;

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

    public static void main(String[] args) {
        twoSum(new int[]{-1, 0}, -1);
    }
}
