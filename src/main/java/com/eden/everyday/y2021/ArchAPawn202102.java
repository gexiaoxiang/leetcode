package com.eden.everyday.y2021;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/2/2
 * @Version V1.0
 **/
public class ArchAPawn202102 {
    /**
     * @Description: 424. 替换后的最长重复字符
     * @Author: gexx
     * @Date: 2021/2/2
     **/
    public static int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;

    }

    public static void main(String[] args) {

        characterReplacement("AABBBCBB",1);
    }

}
