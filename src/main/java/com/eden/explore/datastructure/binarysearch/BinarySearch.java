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

    /**
     * @Description: 搜索旋转排序数组
     * @Author: gexx
     * @Date: 2020/3/16
     **/
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //条件1
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //条件2
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * @Description: 寻找峰值
     * @Author: gexx
     * @Date: 2020/3/16
     **/
    public static int findPeakElement(int[] nums) {

        if (nums.length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0; // 因为nums[-1]为负无穷，此时nums[0]满足
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1; // 因为nums[nums.length]为负无穷，此时nums[length-1]满足
        int l = 1, r = nums.length - 2; //因为已经判断了nums[0]和nums[length-1]是否满足，所以缩小范围防止溢出
        return find(nums, l, r);
    }

    public static int find(int[] nums, int l, int r) {
        if (l >= r)
            return r;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;
        if (nums[mid] < nums[mid - 1])
            return find(nums, l, mid - 1);
        else
            return find(nums, mid + 1, r);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        search(nums, target);
    }

}
