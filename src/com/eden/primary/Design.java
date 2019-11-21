package com.eden.primary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
    }

}
