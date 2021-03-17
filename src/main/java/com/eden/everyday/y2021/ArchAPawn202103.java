package com.eden.everyday.y2021;

import java.util.*;

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

    /**
     * @Description: 224. 基本计算器
     * @Author: gexx
     * @Date: 2021/3/10
     **/
    public static int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;

    }

    /**
     * @Description: 227. 基本计算器 II
     * @Author: gexx
     * @Date: 2021/3/11
     **/
    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;

                }
                preSign = ch;
                num = 0;
            }

        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    /**
     * @Description: 331. 验证二叉树的前序序列化
     * @Author: gexx
     * @Date: 2021/3/12
     **/
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();

    }


    /**
     * @author gexx
     * @Description 706. 设计哈希映射
     * @Date 2021/3/14
     **/
    class MyHashMap {
        Integer data[];

        public MyHashMap() {
            data = new Integer[1000001];
        }

        public void put(int key, int value) {
            data[key] = value;
        }

        public int get(int key) {
            return data[key] == null ? -1 : data[key];
        }

        public void remove(int key) {
            data[key] = null;
        }
    }

    /**
     * @Description: 59. 螺旋矩阵 II
     * @Author: gexx
     * @Date: 2021/3/16
     **/
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1, j = 0;
        while (c <= n * n) {

            for (int i = j; i < n - j; i++)
                arr[j][i] = c++;
            for (int i = j + 1; i < n - j; i++)
                arr[i][n - j - 1] = c++;
            for (int i = n - j - 2; i >= j; i--)
                arr[n - j - 1][i] = c++;
            for (int i = n - j - 2; i > j; i--)
                arr[i][j] = c++;

            j++;
        }

        return arr;
    }


    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        minCut("ssop");
        calculate2("3+2*2");
    }
}
