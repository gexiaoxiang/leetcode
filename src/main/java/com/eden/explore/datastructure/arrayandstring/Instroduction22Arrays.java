package com.eden.explore.datastructure.arrayandstring;

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
        int[] new_array = new int[m*n];
        int[][] trans = {{-1,1},{1,-1}};
        int raw = 0;
        int col = 0;
        int k = 0;
        for(int i=0;i<new_array.length;i++){
            new_array[i] = matrix[raw][col];
            raw += trans[k][0];
            col += trans[k][1];

            if(col > n-1){
                col = n-1;
                raw += 2;
                k = 1 - k;
            }
            if(raw > m-1){
                raw = m-1;
                col += 2;
                k = 1 - k;
            }
            if(col < 0){
                col = 0;
                k = 1 - k;
            }
            if(raw < 0){
                raw = 0;
                k = 1 - k;
            }
        }
        return new_array;
    }
}
