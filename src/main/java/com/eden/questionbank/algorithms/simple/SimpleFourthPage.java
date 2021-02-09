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

    /**
     * @Description: 1374. 生成每种字符都是奇数个的字符串
     * @Author: gexx
     * @Date: 2021/2/19
     **/
    public String generateTheString(int n) {

        StringBuffer ret = new StringBuffer();
        if (n % 2 == 0) {
            ret.append("a");
            for (int i = 0; i < n - 1; i++) {
                ret.append("b");
            }
        } else {
            for (int i = 0; i < n; i++) {
                ret.append("a");
            }
        }

        return ret.toString();
    }

    /**
     * @Description: 1380. 矩阵中的幸运数
     * @Author: gexx
     * @Date: 2021/2/19
     **/
    public List<Integer> luckyNumbers(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[] rMin = new int[r];
        Arrays.fill(rMin, Integer.MAX_VALUE);
        int[] cMax = new int[c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                rMin[i] = Math.min(rMin[i], matrix[i][j]);
                cMax[j] = Math.max(cMax[j], matrix[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == rMin[i] && matrix[i][j] == cMax[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }


    /**
     * @Description 1331. 数组序号转换
     * @author gexx
     * @Date 2021/2/9
     **/
    public int[] arrayRankTransform(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int[] count = new int[max - min + 1];
        for (int num : arr)
            count[num - min] = 1;

        int[] preSum = new int[count.length + 1];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + count[i - 1];

        int[] ans = new int[arr.length];
        int index = 0;
        for (int num : arr)
            ans[index++] = preSum[num - min] + 1;

        return ans;


    }
    /**
     * @Description 1332. 删除回文子序列
     * @author gexx
     * @Date 2021/2/9
     **/
    public int removePalindromeSub(String s) {
        if ("".equals(s)) return 0;
        if (s.equals(new StringBuilder(s).reverse().toString())) return 1;
        return 2;
    }

    public static void main(String[] args) {
        decompressRLElist(new int[]{1, 2, 3, 4});
    }
}
