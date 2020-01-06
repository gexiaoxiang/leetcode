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

    /**
     * @Description: 两数之和 II - 输入有序数组
     * @Param: [numbers, target]
     * @Return: int[]
     * @Author: gexx
     * @Date: 2020/1/2
     **/
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }

    /**
     * @Description:   移除元素
     * @Param: [nums, val]
     * @Return: int
     * @Author: gexx
     * @Date: 2020/1/6
     **/
    public static int removeElement(int[] nums, int val) {


        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;


    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
        int nums1[] = {2, 7, 11, 15};
        System.out.println(removeElement(nums1, 2));
    }

}
