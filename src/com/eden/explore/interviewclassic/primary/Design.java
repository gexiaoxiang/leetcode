package com.eden.explore.interviewclassic.primary;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @Description: 设计问题
 * @Author gexx
 * @Date 2019/11/21
 * @Version V1.0
 **/
public class Design {

    static   class Solution {
    static  private int[] nums = null;
    private Random random;
    private int[] copy;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
        copy = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = nums.length;

        while (n > 1) {
            int k = random.nextInt(n);
            n--;
            int value = copy[k];
            copy[k] = copy[n];
            copy[n] = value;
        }
        return copy;
    }
    }

    /**
     * 最小栈
     */
    static class MinStack {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStack() {
            this.stack1 = new Stack<Integer>();
            this.stack2 = new Stack<Integer>();
        }

        public void push(int x) {
            this.stack1.push(x);
            if(this.stack2.isEmpty()){
                this.stack2.push(x);
            }else if(x < this.stack2.peek()){
                this.stack2.push(x);
            }else{
                this.stack2.push(stack2.peek());
            }
        }

        public void pop() {
            this.stack1.pop();
            this.stack2.pop();
        }

        public int top() {
            return this.stack1.peek();
        }

        public int getMin() {
            return this.stack2.peek();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
        minStack.getMin();

    }

}
