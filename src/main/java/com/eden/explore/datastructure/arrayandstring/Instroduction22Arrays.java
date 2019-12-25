package com.eden.explore.datastructure.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二维数组简介
 * @Author gexx
 * @Date 2019/12/25
 * @Version V1.0
 **/
public class Instroduction22Arrays {
    /**
     * @Description: 对角线遍历
     * @Param: [matrix]
     * @Return: int[]
     * @Author: gexx
     * @Date: 2019/12/25
     **/
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] new_array = new int[m * n];
        int[][] trans = {{-1, 1}, {1, -1}};
        int raw = 0;
        int col = 0;
        int k = 0;
        for (int i = 0; i < new_array.length; i++) {
            new_array[i] = matrix[raw][col];
            raw += trans[k][0];
            col += trans[k][1];

            if (col > n - 1) {
                col = n - 1;
                raw += 2;
                k = 1 - k;
            }
            if (raw > m - 1) {
                raw = m - 1;
                col += 2;
                k = 1 - k;
            }
            if (col < 0) {
                col = 0;
                k = 1 - k;
            }
            if (raw < 0) {
                raw = 0;
                k = 1 - k;
            }
        }
        return new_array;
    }

    /**
     * @Description: 螺旋矩阵
     * @Param: [matrix]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: gexx
     * @Date: 2019/12/25
     **/
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] status = new boolean[row][col];
        int len = row * col;
        int x = 0, y = 0;
        while (true) {
            if (list.size() == len) {
                break;
            }
            //向右
            while (y < col && !status[x][y] && list.size() < len) {
                list.add(matrix[x][y]);
                status[x][y] = true;
                y++;
            }
            y--;
            x++;
            //向下
            while (x < row && !status[x][y] && list.size() < len) {
                list.add(matrix[x][y]);
                status[x][y] = true;
                x++;
            }
            x--;
            y--;
            //向左
            while (y >= 0 && !status[x][y] && list.size() < len) {
                list.add(matrix[x][y]);
                status[x][y] = true;
                y--;
            }
            y++;
            x--;
            //向上
            while (x >= 0 && !status[x][y] && list.size() < len) {
                list.add(matrix[x][y]);
                status[x][y] = true;
                x--;
            }
            x++;
            y++;
        }
        return list;


    }
}
