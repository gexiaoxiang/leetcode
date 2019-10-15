package com.eden.primary;

/**
 * @Description: 字符串相关算法
 * @Author gexx
 * @Date 2019/10/14
 * @Version V1.0
 **/
public class Strings {

    /**
     * @Description: 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * @Param: [s]
     * @Return: void
     * @Author: gexx
     * @Date: 2019/10/14
     **/
    public static void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char mid = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = mid;
        }
        System.out.println(s);

    }

    /**
     * @Description: 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * @Param: [x]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/10/15
     **/
    public static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuffer stringBuffer = new StringBuffer(s.length());
        stringBuffer.append(x);
        if (x < 0) {
            stringBuffer.deleteCharAt(0);
            stringBuffer.reverse();
            stringBuffer.insert(0, '-');
        } else {
            stringBuffer.reverse();
        }
        long sss = Long.valueOf(stringBuffer.toString());

        if (sss >= Integer.MAX_VALUE ||
                sss <= Integer.MIN_VALUE) {
            return 0;
        }
        Integer re = Integer.valueOf(stringBuffer.toString());

        return re;
    }

    public static void main(String[] args) {
        //反转字符串
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        //整数反转
//        int x=9646324351;
        int x = 123;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

}
