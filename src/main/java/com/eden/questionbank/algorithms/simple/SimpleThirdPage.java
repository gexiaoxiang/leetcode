package com.eden.questionbank.algorithms.simple;

/**
 * @Description: 简单 page 3  size 100
 * @Author: gexx
 * @Date: 2020/12/16
 **/
public class SimpleThirdPage {
    /**
     * @Description: 比较含退格的字符串
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static boolean backspaceCompare(String S, String T) {
        int sL = S.length();
        int tL = T.length();
        boolean eq;
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < sL; i++) {
            if (S.charAt(i) == '#' && sbs.length() != 0) {
                sbs.deleteCharAt(sbs.length() - 1);
            } else {
                sbs.append(S.charAt(i));
            }
        }
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < tL; i++) {
            if (T.charAt(i) == '#' && sbl.length() != 0) {
                sbl.deleteCharAt(sbl.length() - 1);
            } else {
                sbl.append(T.charAt(i));
            }
        }
        eq = sbs.toString().replace("#", "").equals(sbl.toString().replace("#", ""));

        return eq;
    }
}
