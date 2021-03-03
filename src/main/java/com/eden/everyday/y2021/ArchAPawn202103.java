package com.eden.everyday.y2021;

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
}
