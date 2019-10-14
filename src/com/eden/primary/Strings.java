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

        for (int i = 0; i < s.length/ 2; i++) {
                char mid = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = mid;
        }
        System.out.println(s);

    }

    public static void main(String[] args) {
        //
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
}
