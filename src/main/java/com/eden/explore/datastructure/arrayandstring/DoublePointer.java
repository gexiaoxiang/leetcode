package com.eden.explore.datastructure.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * @Description: 移除元素
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

    /**
     * @Description: 最大连续1的个数
     * @Param: [nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2020/1/7
     **/
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxMiddleInt = 0;
        int maxInt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (1 == nums[i]) {
                maxMiddleInt++;
            } else {
                maxInt = Math.max(maxMiddleInt, maxInt);
                maxMiddleInt = 0;
            }
        }

        return Math.max(maxMiddleInt, maxInt);
    }

    /**
     * @Description: 长度最小的子数组
     * @Param: [s, nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2020/1/7
     **/
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int i = 0;
        int j = 0;
        int sum = nums[i];
        int min = Integer.MAX_VALUE;
        while (j < nums.length && i <= j) {
            if (sum < s) {
                j++;
                if (j >= nums.length) {
                    break;
                }
                sum += nums[j];
            } else {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
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
