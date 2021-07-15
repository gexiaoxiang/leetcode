package com.eden.everyday.y2021;


import java.util.Arrays;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/6/5
 * @Version V1.0
 **/
public class ArchAPawn202107 {
    /**
     * @Description: 1846. 减小和重新排列数组后的最大元素
     * @Author: gexx
     * @Date: 2021/7/15
     **/
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
