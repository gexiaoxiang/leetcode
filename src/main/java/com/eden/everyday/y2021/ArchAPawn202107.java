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

    /**
     * @Description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * @Author: gexx
     * @Date: 2021/7/16
     **/
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length - 1;
        int l = 0, r = n;
        // 右边界
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (nums[l] != target) return 0; // 没有找到直接返回0
        int right = r;
        // 左边界
        l = 0;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? right - l + 1 : 0;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @Description: 剑指 Offer 52. 两个链表的第一个公共节点
     * @Author: gexx
     * @Date: 2021/7/21
     **/
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode ta = a, tb = b;
        while (ta != tb) {
            ta = ta == null ? b : ta.next;
            tb = tb == null ? a : tb.next;
        }
        return ta;
    }

    /**
     * @Description: 1893. 检查是否区域内所有整数都被覆盖
     * @Author: gexx
     * @Date: 2021/7/23
     **/
    public boolean isCovered(int[][] ranges, int left, int right) {

        for (int i = left; i <= right; i++) {
            boolean overFalg = false;
            for (int[] range : ranges) {
                if ((range[0] <= i && range[1] >= i)) {
                    overFalg = true;
                    continue;
                }

            }
            if (!overFalg) {
                return false;
            }
        }


        return true;
    }

    /**
     * 1886. 判断矩阵经轮转后是否一致
     *
     * @param mat
     * @param target
     * @return
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean b1 = true, b2 = true, b3 = true, b4 = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //旋转90度
                if (mat[n - j - 1][i] != target[i][j]) {
                    b1 = false;
                }
                //旋转180度
                if (mat[n - i - 1][n - j - 1] != target[i][j]) {
                    b2 = false;
                }
                //旋转270度
                if (mat[j][n - i - 1] != target[i][j]) {
                    b3 = false;
                }
                //旋转360度
                if (mat[i][j] != target[i][j]) {
                    b4 = false;
                }
            }
        }
        return b1 || b2 || b3 || b4;
    }


}
