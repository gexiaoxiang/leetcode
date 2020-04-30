package com.eden.explore.arrayalgorithm;

import java.util.*;

/**
 * @Description: 数组类算法
 * @Author gexx
 * @Date 2020/4/29
 * @Version V1.0
 **/
public class ArrayAlgorithm {
    /**
     * @Description: 删除排序数组中的重复项 II
     * @Author: gexx
     * @Date: 2020/4/30
     **/
    public int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int i = 1;
        for (int j = i + 1; j < nums.length; ++j) {
            if (nums[i] != nums[j] || (nums[j] == nums[i] && nums[i - 1] != nums[j])) {
                nums[i + 1] = nums[j];
                ++i;
            }
        }
        return i + 1;
    }

    /**
     * @Description: 颜色分类
     * @Author: gexx
     * @Date: 2020/4/30
     **/

    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * @Description: 数组中的第K个最大元素
     * @Author: gexx
     * @Date: 2020/4/30
     **/

    public static int findKthLargest(int[] ints, int k) {
        Arrays.sort(ints);

        System.out.println(ints[ints.length - k]);

        return ints[ints.length - k];
    }


    /**
     * @Description: 反转字符串中的元音字母
     * @Author: gexx
     * @Date: 2020/4/30
     **/


    public static String reverseVowels(String s) {
        //定义一个集合用来存放元音字母
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int pL = 0;//左指针
        int pR = s.length() - 1;//右指针
        char[] result = new char[s.length()];//创建新数组
        while (pL <= pR) {
            if (!vowels.contains(s.charAt(pL))) {//判断左指针指向元素是否为元音字母
                result[pL] = s.charAt(pL);//如果不是向新数组对应下标赋值该元素，左指针右移
                pL++;
            } else if (!vowels.contains(s.charAt(pR))) {//判断右指针指向元素是否为元音字母
                result[pR] = s.charAt(pR);//如果不是向新数组对应下标赋值该元素，右指针左移
                pR--;
            } else {//当左右指针都指向元音字母，向新数组pR下标赋值为s字符串pL下标的元音字母
                //新数组pL下标赋值为s字符串pR下标的元音字母，来实现元音反转调换
                result[pR] = s.charAt(pL);
                result[pL] = s.charAt(pR);
                pL++;
                pR--;
            }
        }
        return new String(result);//最后将新数组作为String参数，返回新的字符串
    }

    /**
     * @Description: 盛最多水的容器
     * @Author: gexx
     * @Date: 2020/4/30
     **/
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);  //面积为底乘以高
            res = Math.max(res, area);  //选出大的面积
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    /**
     * @Description: 根据字符出现频率排序
     * @Author: gexx
     * @Date: 2020/4/30
     **/
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mp.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> en = list.get(i);
            char key = en.getKey();
            int val = en.getValue();
            for (int j = 0; j < val; j++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] ss = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        findKthLargest(ss, 4);
    }

}
