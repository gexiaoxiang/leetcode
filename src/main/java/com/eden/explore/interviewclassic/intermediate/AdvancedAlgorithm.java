package com.eden.explore.interviewclassic.intermediate;

/**
 * @Description: Advanced algorithm
 * @Author gexx
 * @Date 2020/6/22
 * @Version V1.0
 **/
public class AdvancedAlgorithm {
    /**
     * @Description: 除自身以外数组的乘积
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int n1[] = new int[n];
        int n2[] = new int[n];
        n1[0] = 1;
        n2[0] = 1;
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            n1[i] = nums[i - 1] * n1[i - 1];
            n2[i] = nums[n - i] * n2[i - 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = n1[i] * n2[n - i - 1];
        }
        return result;

    }

    /**
     * @Description: 生命游戏
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        int rows = board.length;
        int cols = board[0].length;
        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //用于记录这个格子的四周有几个存活的细胞
                int count = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                count++;
                            }
                        }
                    }
                }
                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (count < 2 || count > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && count == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }
        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    /**
     * @Description: 缺失的第一个正数
     * @Author: gexx
     * @Date: 2020/6/24
     **/
    public static int firstMissingPositive(int[] nums) {
        boolean[] verify = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] < verify.length) {
                    verify[nums[i]] = true;
                }
            }
        }
        for (int i = 1; i < verify.length; i++) {
            if (verify[i] == false) {
                return i;
            }
        }
        return verify.length;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        firstMissingPositive(nums);
    }
}
