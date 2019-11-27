package com.eden.explore.interviewclassic.primary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 数组相关算法
 * @author: gexx
 * @date: 2019/9/25
 **/
public class Arrays {


    /**
     * @Description: 给定两个数组，编写一个函数来计算它们的交集
     * 示例 1:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * @Param: [nums1, nums2]
     * @return: int[]
     * @User: gexx
     * @Date: 2019/9/26
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        //将数组排序
        java.util.Arrays.sort(nums1);
        java.util.Arrays.sort(nums2);
        List<Integer> middleList = new ArrayList<Integer>();

        for (int x = 0, y = 0; x < nums1.length && y < nums2.length; ) {
            if (nums1[x] == nums2[y]) {
                middleList.add(nums1[x]);
                x++;
                y++;
            } else if (nums1[x] > nums2[y]) {
                y++;
            } else {
                x++;
            }

        }
        int[] finalArray = new int[middleList.size()];
        for (int i = 0; i < middleList.size(); i++) {
            finalArray[i] = middleList.get(i);
        }
        return finalArray;
    }

    /**
     * @Description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头
     * @Param: [digits]
     * @Return: int[]
     * @Author: gexx
     * @Date: 2019/9/30
     **/
    public static int[] plusOne(int[] digits) {

        int len = digits.length;
        int i = len - 1;
        int th = 9;
        digits[i] += 1;
        if (digits[i] > th) {   //大于9  产生进位
            while (i > 0 && digits[i] > th) {
                digits[i] = 0;
                digits[--i] += 1;
            }
            if (i == 0 && digits[i] > th) {   //如果首位大于9， 将数组扩大一位，首位变为1
                digits = new int[len + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }

    /**
     * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:  输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
     * 说明:必须在原数组上操作，不能拷贝额外的数组.尽量减少操作次数。
     * @Param: [nums]
     * @Return: void
     * @Author: gexx
     * @Date: 2019/10/9
     **/
    public static void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                zeroNum++;
            } else if (zeroNum != 0) {
                nums[i - zeroNum] = nums[i];
                nums[i] = 0;
            }
        }

    }

    /**
     * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * @Param: [nums, target]
     * @Return: int[]
     * @Author: gexx
     * @Date: 2019/10/10
     **/
    public static int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    re[0] = i;
                    re[1] = j;
                    return re;
                }
            }
        }

        return re;
    }

    /**
     * @Description: 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * @Param: [board]
     * @Return: boolean
     * @Author: gexx
     * @Date: 2019/10/11
     **/
    public static boolean isValidSudoku(char[][] board) {
        //验证每一行
        int length = board.length;
        for (int i = 0; i < length; i++) {
            char[] chars = board[i];
            List chars1 = new ArrayList();
            for (int a = 0; a < chars.length; a++) {
                if ('.' == chars[a]) {
                } else {
                    chars1.add(chars[a]);
                }
            }
            int chars1Size = chars1.size();
            HashMap map = new HashMap<>();
            for (int j = 0; j < chars1.size(); j++) {
                char o = (char) chars1.get(j);
                map.put(o, "");
            }
            if (map.size() != chars1Size) {
                return false;
            }
        }


        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] col = new int[9];
            int[] cube = new int[9];

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1'] == 1) {
                        return false;
                    } else {
                        row[board[i][j] - '1'] = 1;
                    }
                }

                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1'] == 1) {
                        return false;
                    } else {
                        col[board[j][i] - '1'] = 1;
                    }
                }
                // 每一宫内行列的变化
                int cubeX = 3 * (i / 3) + j / 3;
                int cubeY = 3 * (i % 3) + j % 3;
                if (board[cubeX][cubeY] != '.') {
                    if (cube[board[cubeX][cubeY] - '1'] == 1) {
                        return false;
                    } else {
                        cube[board[cubeX][cubeY] - '1'] = 1;
                    }
                }
            }

        }
        return true;

    }

    /**
     * @Description: 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像顺时针旋转 90 度。
     * 说明：
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     * @Param: [matrix]
     * @Return: void
     * @Author: gexx
     * @Date: 2019/10/12
     **/
    public static void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int col = matrix.length - 1;
        for (int j = 0; j < matrix.length / 2; j++, col--) {
            int r = col;//记录最后
            int c = 0;//记录开始
            for (int i = j; i < col; i++) {
                swap(matrix, i, j, r, i);
                swap(matrix, r, i, r - c, r);
                swap(matrix, r - c, r, j, r - c);
                c++;
            }
        }
    }

    private static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }


    public static void main(String[] args) {

        //交集
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(java.util.Arrays.toString(intersect));
        int[] plusOne = {4, 3, 2, 1};
        System.out.println(java.util.Arrays.toString(plusOne(plusOne)));
        //移动0
        int[] nums3 = {0, 1, 0, 3, 12};
        moveZeroes(nums3);
        System.out.println(java.util.Arrays.toString(nums3));
        //两数之和
        int[] nums4 = {3, 2, 4};
        int target = 6;
        int[] ints = twoSum(nums4, target);
        System.out.println(java.util.Arrays.toString(ints));
        //有效数独
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
        //旋转图像
        int[][] matrix =
                {
                        {5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}
                };
        rotate(matrix);
    }


}