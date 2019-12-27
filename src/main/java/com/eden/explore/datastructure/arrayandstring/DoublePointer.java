package com.eden.explore.datastructure.arrayandstring;

import java.util.Arrays;

/**
 * @Description: 双指针
 * @Author gexx
 * @Date 2019/12/27
 * @Version V1.0
 **/
public class DoublePointer {
    /**
     * @Description: 双指针
     * @Param: [nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/12/27
     **/

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;

    }

    public static void main(String[] args) {
        int []nums={1,4,3,2};
        System.out.println( arrayPairSum(nums));
    }

}
