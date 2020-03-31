package com.eden.explore.datastructure.binarysearch;

import java.util.*;

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


    /**
     * @Description 寻找比目标字母大的最小字母
     * @author gexx
     * @Date 2020/3/25
     **/
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] > target) {
                r = mid;//mid-1不通过
            } else {
                l = mid + 1;
            }
        }
        return l < n ? letters[r] : letters[0];//l r相等 都可以

    }


    /**
     * @Description 寻找重复数
     * @author gexx
     * @Date 2020/3/26
     **/
    public static int findDuplicate(int[] nums) {
        Set set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * @Description 寻找两个有序数组的中位数
     * @author gexx
     * @Date 2020/3/31
     **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num = 0;
        int prenum = 0;        //当总长度为偶数，中位数等于num和prenum的平均值，当总长度为奇数，中位数为num
        double d = 0;          //返回最终的中位数
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {         //首先判断nums1或nums2为空的情况，返回不为空的数组的中位数即可
            if (len2 % 2 == 0)
                d = (double) (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2;
            else
                d = nums2[len2 / 2];
            return d;
        } else if (len2 == 0) {
            if (len1 % 2 == 0)
                d = (double) (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2;
            else
                d = nums1[len1 / 2];
            return d;
        }
        int i = 0;    //当nums1和nums2数组都不为空时，设num1和nums2的索引分别为i和j，并初始化为0
        int j = 0;
        int number = 0;    //记录当前nums1和nums2的参与排序的元素个数
        int mid = (len1 + len2) / 2;     //当总长度为偶数，中位数为索引为mid和mid-1的元素的平均数，当总长度为奇数，中位数取索引为mid的元素，因此只需要找到前mid个最小的数排序即可
        while (i < len1 && j < len2 && number <= mid) { //当nums1或nums2遍历完或找到计算中位数所需的位数即退出循环
            if (nums1[i] <= nums2[j]) {      //num1当前元素小时，nums1当前索引加一，并且number加一
                prenum = num;
                num = nums1[i];
                i++;
                number++;
            } else {      //num2当前元素小时，nums2当前索引加一，并且number加一
                prenum = num;
                num = nums2[j];
                j++;
                number++;
            }
        }
        if (i == len1) {     //判断如果nums1全部遍历完了，接下来只需遍历nums2即可
            while (number <= mid) {
                prenum = num;
                num = nums2[j];
                j++;
                number++;
            }
        } else if (j == len2) {      //判断如果nums2全部遍历完了，接下来只需遍历nums1即可
            while (number <= mid) {
                prenum = num;
                num = nums1[i];
                i++;
                number++;
            }
        }
        if (number == mid + 1) {    //最后找到找到中位数所需的所有位数后计算中位数
            int remain = (len1 + len2) % 2;
            if (remain == 0)
                d = (double) (prenum + num) / 2;
            else
                d = num;
        }
        return d;     //返回中位数
    }

    /**
     * @Description 找出第 k 小的距离对
     * @author gexx
     * @Date 2020/4/1
     **/
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.parallelSort(nums);

        int[] d = new int[nums.length - 1];

        for (int i = 1; i < nums.length; i++)
            d[i - 1] = nums[i] - nums[i - 1];

        int[] sum = new int[d.length];

        sum[0] = d[0];
        for (int i = 1; i < d.length; i++)
            sum[i] = sum[i - 1] + d[i];

        int ans = 0;
        int l = 0, r = sum[d.length - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(sum, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }

        return ans;
    }

    private boolean check(int[] sum, int k, int d) {

        int num = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > d) {
                int l = 0, r = i - 1, p = i;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (sum[i] - sum[mid] <= d) {
                        p = mid;
                        r = mid - 1;
                    } else
                        l = mid + 1;
                }
                num += i - p;
            } else
                num += i + 1;
        }

        return num >= k;
    }

    /**
     * @Description 分割数组的最大值
     * @author gexx
     * @Date 2020/4/1
     **/
    public int splitArray(int[] nums, int m) {
        long left = 0, right = 0;
        for (int n : nums) {
            right += n;
        }
        if (m == 1) {
            return (int) right;
        }
        long result = 0;
        long mid;
        while (left <= right) {
            mid = left + right >> 1;
            if (judge(mid, nums, m)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) result;
    }

    private boolean judge(long mid, int[] nums, int m) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return false;
            }
            if (sum + nums[i] > mid) {
                sum = nums[i];
                m--;
            } else {
                sum += nums[i];
            }
        }
        return m >= 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        search(nums, target);
    }

}
