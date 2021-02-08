package com.eden.questionbank.algorithms.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gexx
 * @Description 简单 page 4  size 100
 * @Date 2021/2/8
 **/
public class SimpleFourthPage {

    /**
     * @Description 1313. 解压缩编码列表
     * @Author gexx
     * @Date 2021/2/8
     **/
    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int i1 = 0; i1 < nums[i]; i1++) {
                list.add(nums[i + 1]);
            }
        }
        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * @Description 1317. 将整数转换为两个无零整数的和
     * @author gexx
     * @Date 2021/2/8
     **/
    public int[] getNoZeroIntegers(int n) {
        int[] rs = new int[2];
        for (int i = 1; i < n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                return new int[]{i, n - i};
            }
        }
        return rs;
    }


    /**
     * @Description 1323. 6 和 9 组成的最大数字
     * @author gexx
     * @Date 2021/2/8
     **/
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        String s1 = s.replaceFirst("6", "9");
        Integer integer = Integer.valueOf(s1);
        return integer;
    }

    public static void main(String[] args) {
        decompressRLElist(new int[]{1, 2, 3, 4});
    }
}
