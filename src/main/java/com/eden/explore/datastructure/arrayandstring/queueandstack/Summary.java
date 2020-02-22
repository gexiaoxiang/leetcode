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

}
