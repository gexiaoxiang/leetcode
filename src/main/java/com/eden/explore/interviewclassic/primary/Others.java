package com.eden.explore.interviewclassic.primary;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 其他类型的题目
 * @Author gexx
 * @Date 2019/11/29
 * @Version V1.0
 **/
public class Others {
    /**
     * @Description: 位1的个数
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
     * @Param: [n]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/29
     **/
    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;

    }

    /**
     * @Description: 汉明距离
     * @Param: [x, y]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/12/4
     **/
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;

    }

    /**
     * @Description: 颠倒二进制位
     * @Param: [n]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/12/4
     **/
    public int reverseBits(int n) {

        int ret = 0;
        int temp1 = 0;
        for (int i = 31; i >= 0; i--) {
            int temp = 1;
            temp <<= i;
            temp1 = temp & n;// 取出对应的数字；
            if (temp1 != 0) {
                int temp2 = 1;
                temp2 <<= (31 - i);
                ret |= temp2;
            }

        }

        return ret;
    }

    /**
     * @Description: 帕斯卡三角形
     * @Param: [numRows]
     * @Author: gexx
     * @Date: 2019/12/4
     **/
    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();

        if (numRows >= 1) {
            List<Integer> data = new ArrayList<>();
            data.add(1);
            list.add(data);
        }

        if (numRows >= 2) {
            List<Integer> data = new ArrayList<>();
            data.add(1);
            data.add(1);
            list.add(data);
        }

        if (numRows >= 3) {
            for (int i = 3; i <= numRows; i++) {
                List<Integer> data = new ArrayList<>();
                List<Integer> prev = list.get(i - 2);
                data.add(1);
                for (int j = 2; j <= i - 1; j++) {
                    data.add(prev.get(j - 2) + prev.get(j - 1));
                }
                data.add(1);

                list.add(data);
            }
        }

        return list;
    }

    /**
     * @Description: 有效的括号
     * @Param: [s]
     * @Return: boolean
     * @Author: gexx
     * @Date: 2019/12/5
     **/
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (ch == ')' && topChar != '(') {
                    return false;
                } else if (ch == ']' && topChar != '[') {
                    return false;
                } else if (ch == '}' && topChar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

    /**
     * @Description: 缺失数字
     * @Param: [nums]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/12/6
     **/
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        if (nums[0] != 0) {
            return 0;
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(isValid("()"));
        int[] nums = {1};
        System.out.println(missingNumber(nums));
    }
}