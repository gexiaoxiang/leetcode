package com.eden.explore.datastructure.arrayandstring;

import java.util.Arrays;

/**
 * @Description: 字符串简介
 * @Author gexx
 * @Date 2019/12/27
 * @Version V1.0
 **/
public class Introduction2String {
    /**
     * @Description: 二进制求和
     * @Param: [a, b]
     * @Return: java.lang.String
     * @Author: gexx
     * @Date: 2019/12/27
     **/
    public static String addBinary(String a, String b) {
        String result = "";
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int sum = 0;
        while (aLen >= 0 || bLen >= 0) {
            if (aLen >= 0) {
                sum += Integer.parseInt(a.substring(aLen, aLen + 1));
                aLen--;
            }
            if (bLen >= 0) {
                sum += Integer.parseInt(b.substring(bLen, bLen + 1));
                bLen--;
            }
            if (sum == 2) {
                result = "0" + result;
                sum = 1;
            } else if (sum == 0 || sum == 1) {
                result = sum + "" + result;
                sum = 0;
            } else if (sum == 3) {
                result = "1" + result;
                sum = 1;
            }
        }
        if (sum == 1)
            result = "1" + result;
        return result;
    }

}
