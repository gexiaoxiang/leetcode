package com.eden.explore.datastructure.arrayandstring;

import java.util.Arrays;

/**
 * @Description: 数组简介
 * @Author gexx
 * @Date 2019/12/20
 * @Version V1.0
 **/
public class Introduction2Arrays {
    /**
     * @Description: 寻找数组的中心索引
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * @Param: [nums]
     * @Return: in
     * @Author: gexx
     * @Date: 2019/12/20
     **/
    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    /**
     * @Description: 至少是其他数字两倍的最大数
     * @Param: [nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/12/23
     **/

    public static int dominantIndex(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        if (nums.length == 1) return 0;
        int max = clone[clone.length - 1];
        int maxL = clone[clone.length - 2];
        if (maxL == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (max == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
        if (max / maxL < 2) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @Description: 搜索插入位置
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public static int searchInsert(int[] nums, int target) {
        int ret = 0;
        if (target < nums[0]) return ret;
        if (target > nums[nums.length - 1]) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return i;
            if (target > nums[i] && target < nums[i + 1]) return i + 1;
        }
        return ret;
    }

    /**
     * @Description: 旋转矩阵
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
    /**
      * @Description: 零矩阵
    
      * @Author: gexx
      * @Date: 2020/6/22
      **/
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //将出现0位置的首行和首列的相应位置设置为0，用来设置内矩阵的0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) row = true;//当前位置本来就在首列，
                    if (j == 0) col = true;//首行
                }
            }
        }
        for (int i = 1; i < m; i++) {   //遍历行首为0的行，从第二行开始，所以后面需要用col的值来设置第一行
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {   //遍历列首为0的列，从第二列开始，所以后面需要用row的值来设置第一列
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int nums1[] = {-1, -1, 0, 1, 1, 0};
        int nums2[] = {1, 2, 3};
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
        int nums3[] = {0, 0, 0, 1};
        System.out.println(dominantIndex(nums3));
        int[] nums = {1, 3, 5, 6};
        int a = 5;
        System.out.println(searchInsert(nums, a));
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }
}
