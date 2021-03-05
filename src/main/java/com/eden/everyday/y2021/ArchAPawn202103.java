package com.eden.everyday.y2021;

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
}
