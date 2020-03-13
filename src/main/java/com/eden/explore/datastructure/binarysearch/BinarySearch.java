package com.eden.explore.datastructure.binarysearch;

/**
 * @Description 二分查找
 *
 * @Author gexx
 * @Date 2020/3/13
 **/
public class BinarySearch {

    /**
     * @Description 二分查找
     *
     * @author gexx
     * @Date 2020/3/13
     **/
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] >= target) {   // ==更改的地方== 即发现第一个=的时候
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }

        return -1;
    }

    public static void main(String[] args) {
       int [] nums = {-1,0,3,5,9,12};
    int target = 9;
        search(nums,target);
    }

}
