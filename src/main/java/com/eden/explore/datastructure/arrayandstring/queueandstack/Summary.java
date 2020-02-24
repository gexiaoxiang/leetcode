package com.eden.explore.datastructure.arrayandstring.queueandstack;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @Description 小結
 * @Author gexx
 * @Date 2020/2/20
 **/
public class Summary {

    /**
     * @Description 用栈实现队列
     * @Author gexx
     * @Date 2020/2/20
     **/
    class MyQueue {
        private java.util.Stack<Integer> stack1;
        private java.util.Stack<Integer> stack2;

        /**
         * Initialize your data structure here.
         */

        public MyQueue() {
            stack1 = new java.util.Stack<>();
            stack2 = new java.util.Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        //确保了每个元素只会入栈出栈再入栈出栈两次，即进入桶1，弹出桶1，进入桶2，弹出桶2。
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());//
                }
            }
            return stack2.pop();//若stack2不为空，直接将stack2栈顶元素出栈即可。
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.empty() && stack2.empty();//当二者均为空是，队列为空
        }
    }

    /**
     * @author gexx
     * @Description 用队列实现栈
     * @Date 2020/2/22
     **/
    class MyStack {
        private ArrayDeque queue;

        public MyStack() {
            queue = new ArrayDeque();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);

        }

        public int pop() {
            return (int) queue.pollLast();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return (int) queue.peekLast();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * @Description 字符串解码
     * @author gexx
     * @Date 2020/2/22
     **/
    public static String decodeString(String s) {
        LinkedList<Integer> numStack = new LinkedList();
        LinkedList<String> strStack = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);
            } else if (c == '[') {
                if (num > 0) numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                num = 0;
            } else {
                //c==']'
                StringBuilder preSB = new StringBuilder().append(strStack.pop());
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    preSB.append(sb);
                }
                sb = preSB;
            }
        }
        return sb.toString();
    }

    /**
     * @Description 图像渲染
     * @author gexx
     * @Date 2020/2/23
     **/
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        dfs(image, newColor, sr, sc, target);
        return image;
    }

    private static void dfs(int[][] image, int newColor, int i, int j, int target) {
        if (image[i][j] == newColor || image[i][j] != target) {
            return;
        }
        image[i][j] = newColor;
        if (i > 0) {
            dfs(image, newColor, i - 1, j, target);
        }
        if (i < image.length - 1) {
            dfs(image, newColor, i + 1, j, target);
        }
        if (j > 0) {
            dfs(image, newColor, i, j - 1, target);
        }
        if (j < image[i].length - 1) {
            dfs(image, newColor, i, j + 1, target);
        }
    }

    /**
     * @Description 01 矩阵
     * @author gexx
     * @Date 2020/2/24
     **/
    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 第一次遍历，正向遍历，根据相邻左元素和上元素得出当前元素的对应结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = row + col;
                }
                if (i > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                }
                if (j > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
                }
            }
        }
        // 第二次遍历，反向遍历，根据相邻右元素和下元素及当前元素的结果得出最终结果
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i < row - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                }
                if (j < col - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
                }
            }
        }
        return matrix;
    }
}
