package com.eden.explore.datastructure.arrayandstring.queueandstack;

/**
 * @Description: 栈：后入先出的数据结构
 * @Author gexx
 * @Date 2020/2/14
 * @Version V1.0
 **/
public class Stack {

    /**
     * 最小栈
     */
   static class MinStack {

        private java.util.Stack<Integer> data;
        private java.util.Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            data = new java.util.Stack();
            minStack = new java.util.Stack();
        }

        public void push(int x) {
            data.push(x);
            if(minStack.isEmpty()|| minStack.peek() >= x){
                minStack.push(x);
            }

        }

        public void pop() {
            int x = data.pop();
            if(!minStack.isEmpty() && minStack.peek().equals(x)){
                minStack.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

        public static void main(String[] args) {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin();
            minStack.pop();
            minStack.top();
            minStack.getMin();
        }
    }
}


