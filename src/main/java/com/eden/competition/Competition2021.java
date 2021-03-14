package com.eden.competition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Competition2021 {

    /**
     * @Descriptionv5661. 替换隐藏数字得到的最晚时间
     * @author gexx
     * @Date 2021/1/24
     **/
    public static String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?' && arr[1] == '?') {
            arr[0] = '2';
            arr[1] = '3';
        } else if (arr[0] == '?') {
            if (arr[1] <= '3') {
                arr[0] = '2';
            } else {
                arr[0] = '1';
            }
        } else if (arr[1] == '?') {
            if (arr[0] <= '1') {
                arr[1] = '9';
            } else {
                arr[1] = '3';
            }
        }

        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);


    }


    /**
     * @Description 5654. 盒子中小球的最大数量
     * @author gexx
     * @Date 2021/1/31
     **/
    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> cap = new HashMap();
        for (int i = lowLimit; i <= highLimit; i++) {
            cap.put(sum(i), cap.getOrDefault(sum(i), 0) + 1);
        }
        int maxNum = 0;
        Iterator iterator = cap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            maxNum = Math.max(maxNum, cap.get(key));
        }


        return maxNum;
    }

    public static int sum(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n /= 10;
        }
        sum += n;
        return sum;
    }

    /**
     * @Description 5657. 唯一元素的和
     * @Author gexx
     * @Date 2021/2/6
     **/
    public static int sumOfUnique(int[] nums) {
        int fill[] = new int[101];

        for (int i = 0; i < nums.length; i++) {
            fill[nums[i]] = fill[nums[i]] + 1;
        }
        int sum = 0;
        for (int i = 0; i < fill.length; i++) {
            if (fill[i] == 1) {
                sum += i;
            }
        }

        return sum;

    }

    /**
     * @Description: 5685. 交替合并字符串
     * @Author: gexx
     * @Date: 2021/2/21
     **/
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int word1Length = word1.length();
        int word2Length = word2.length();
        int length;
        String word;
        if (word1Length > word2Length) {
            length = word2.length();
            word = word1;
        } else {
            length = word1.length();
            word = word2;
        }

        for (int i = 0; i < length; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(word.substring(length));
        return sb.toString();
    }


    /**
     * @Description 5680. 找到最近的有相同 X 或 Y 坐标的点
     * @author gexx
     * @Date 2021/3/6
     **/
    public int nearestValidPoint(int x, int y, int[][] points) {

        int minDistance = Integer.MAX_VALUE;
        int index = 0;
        boolean none = false;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                none = true;
                if (minDistance > Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y)) {
                    minDistance = Math.min(minDistance, Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y));
                    index = i;
                }

            }
        }
        if (!none) {
            return -1;

        }

        return index;
    }


    public boolean checkPowersOfThree(int n) {
        for (int i = 0; i < n; n /= 3) if (n % 3 == 2) return false;
        return true;

    }


    public boolean checkOnesSegment(String s) {
        int l = s.indexOf('1');
        int r = s.lastIndexOf('1');
        for (int i = l; i < r; i++) {
            if (s.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }


    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long need = goal - sum;
        long count = 1;
        count = Math.abs(need / limit);
        if (need % limit != 0) {
            count++;
        }


        return (int) count;
    }


    /**
     * @Description 5701. 仅执行一次字符串交换能否使两个字符串相等
     * @author gexx
     * @Date 2021/3/14
     **/
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int count = 0;
        char first = ' ', second = ' ';
        int firstindex = 0, secondIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (first == ' ') {
                    first = s1.charAt(i);
                    firstindex = i;
                } else if (second == ' ') {
                    second = s1.charAt(i);
                    secondIndex = i;
                }
            }
        }
        if (count != 2) {
            return false;
        } else if (s1.charAt(firstindex) == s2.charAt(secondIndex) && s2.charAt(firstindex) == s1.charAt(secondIndex)) {
            return true;
        }

        return false;
    }


    /**
     * @Description 5702. 找出星型图的中心节点
     * @author gexx
     * @Date 2021/3/14
     **/
    public int findCenter(int[][] edges) {
        int[] re = new int[100001];
        for (int i = 0; i < edges.length; i++) {
            re[edges[i][0]]++;
            re[edges[i][1]]++;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < re.length; i++) {
            if (max < re[i]) {
                max = Math.max(max, re[i]);
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public static void main(String[] args) {
        areAlmostEqual("bank", "kanb");
        minElements(new int[]{1000000, 1000000, 1000000, 1000000, 1000000}, 100000, -1000000000);
        sumOfUnique(new int[]{1, 2, 3, 2});

        System.out.println(countBalls(1, 10));
        System.out.println(maximumTime("2?:?0"));
    }
}
