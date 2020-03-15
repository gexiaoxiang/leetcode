package com.eden.explore.datastructure.binarysearch;

/**
 * @Description 二分查找
 * @Author gexx
 * @Date 2020/3/13
 **/
public class BinarySearch {

    /**
     * @Description 二分查找
     * @author gexx
     * @Date 2020/3/13
     **/
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {   // ==更改的地方== 即发现第一个=的时候
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }

        return -1;
    }


    /**
     * @Description x 的平方根
     *
     * @author gexx
     * @Date 2020/3/15
     **/
    public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = (long) (low + high) / 2;
            if (mid * mid < x)
                low = (int) mid + 1;
            else if (mid * mid > x)
                high = (int) mid - 1;
            else
                return (int) mid;
        }
        return high;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        search(nums, target);
    }

}
