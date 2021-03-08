package com.eden.everyday.y2021;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 每日一题
 * @Author gexx
 * @Date 2021/3/2
 * @Version V1.0
 **/
public class ArchAPawn202103 {
    /**
     * @Description: 338. 比特位计数
     * @Author: gexx
     * @Date: 2021/3/3
     **/
    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            String s = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }
            ints[i] = count;
        }
        return ints;
    }

    /**
     * @Description: 232. 用栈实现队列
     * @Author: gexx
     * @Date: 2021/3/5
     **/
    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new LinkedList<Integer>();
            outStack = new LinkedList<Integer>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }


    /**
     * @Description 下一个更大元素 II
     * @author gexx
     * @Date 2021/3/6
     **/
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    /**
     * @Description: 132. 分割回文串 II
     * @Author: gexx
     * @Date: 2021/3/8
     **/
    public static int minCut(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        // dp[2] = 1，表示子串 [0, 2] 中，最少的分割次数是 1
        int[] dp = new int[len];
        // 每个字符都是一个子串的情况，最多切割 len - 1 次
        Arrays.fill(dp, len - 1);
        for (int i = 0; i < len; i++) {
            // bab 的情况，一个 a 在中间
            palindromic(arr, i, i, dp);
            // baac 的情况，两个 a 在中间
            palindromic(arr, i, i + 1, dp);
        }
        return dp[len - 1];
    }

    public static void palindromic(char[] arr, int i, int j, int[] dp) {
        // 中心扩展法，找到以 [i, j] 为中心，向左右两侧能够找到的最大回文串
        while (i >= 0 && j <= arr.length - 1 && arr[i] == arr[j]) {
            int cur = i == 0 ? 0 : dp[i - 1] + 1;
            if (cur < dp[j]) {
                dp[j] = cur;
            }
            i--;
            j++;
        }
    }

}
