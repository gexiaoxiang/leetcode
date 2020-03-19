package com.eden.explore.datastructure.binarysearch;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * @Description 寻找旋转排序数组中的最小值
     * @author gexx
     * @Date 2020/3/17
     **/
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            // 需要与nums[end]比较才能判断出来mid的位置
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                // 存在重复元素时，此题目不重复 可直接使用break
                end = end - 1;
            }
        }
        return nums[start];
    }


    /**
     * @Description 在排序数组中查找元素的第一个和最后一个位置
     * @author gexx
     * @Date 2020/3/19
     **/
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = nums.length - 1;
        int mid = (l + r) / 2;
        boolean flag = false;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            res[0] = -1;
            res[1] = -1;
        } else {
            int i = mid - 1;
            int j = mid + 1;
            while (i >= 0 && nums[i] == target) {
                //while循环条件里的i>=0与nums[i] == target的顺序，
                // 顺序不同导致两个条件判断先后顺序不同，谁在前就先判断哪个条件；如果调换则会造成数组下标越界
                i--;
            }
            res[0] = i + 1;

            while (j < nums.length && nums[j] == target) {
                j++;
            }
            res[1] = j - 1;
        }

        return res;
    }

    /**
     * @Description找到 K 个最接近的元素
     * @author gexx
     * @Date 2020/3/19
     **/
    public List<Integer> findClosestElements(int[] nums, int k, int x) {

        List<Integer> res = new ArrayList<>();
        int start = 0, end = nums.length - k;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (Math.abs(nums[mid] - x) > Math.abs(nums[mid + k] - x)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        for (int i = start; i < start + k; i++) {
            res.add(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        search(nums, target);
    }

}
