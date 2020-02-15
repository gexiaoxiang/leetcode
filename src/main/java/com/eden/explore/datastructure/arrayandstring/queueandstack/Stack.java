package com.eden.explore.datastructure.arrayandstring.queueandstack;

import java.util.Arrays;

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

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new java.util.Stack();
            minStack = new java.util.Stack();
        }

        public void push(int x) {
            data.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }

        }

        public void pop() {
            int x = data.pop();
            if (!minStack.isEmpty() && minStack.peek().equals(x)) {
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

    /**
     * @Description 每日温度
     * @author gexx
     * @Date 2020/2/15
     **/
    public static int[] dailyTemperatures(int[] T) {
        int re[] = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            int count = 0;
            for (int x = i; x < T.length - 1; x++) {
                count++;
                if (T[i] >= T[x + 1]) {
                } else {
                    re[i] = count;
                    break;
                }
            }


        }

        return re;
    }

    /**
     * @Description 逆波兰表达式求值
     * @Author gexx
     * @Date 2020/2/15
     **/
    public static int evalRPN(String[] tokens) {
        java.util.Stack<Integer> stack=new  java.util.Stack<Integer>();
        int num1=0,num2=0;
        for (int i = 0; i < tokens.length; i++) {
            String s=tokens[i];
            if(s.equals("+")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2+num1);
            }else if(s.equals("-")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2-num1);
            }else if(s.equals("*")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2*num1);
            }else if(s.equals("/")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2/num1);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        String tokens[] = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
}


