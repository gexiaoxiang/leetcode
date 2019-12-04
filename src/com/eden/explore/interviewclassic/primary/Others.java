package com.eden.explore.interviewclassic.primary;

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
}
