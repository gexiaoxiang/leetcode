package com.eden.explore.datastructure.hashtables;

import java.util.*;

/**
 * @author gexx
 * @Description 实际应用哈希集合
 * @Date 2020/2/29
 **/
public class PracticalApplication {


    /**
     * @Description 两个数组的交集
     * @author gexx
     * @Date 2020/2/29
     **/
    public static int[] intersection(int[] nums1, int[] nums2) {

        Set hashSet = new HashSet();
        Map<String, Integer> map = new HashMap();
        map.put("len", 0);
        int[] re = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        Arrays.stream(nums1).forEach((item) ->
                hashSet.add(item)
        );
        Arrays.stream(nums2).distinct().forEach(item ->
                {
                    int index = 0;
                    if (hashSet.contains(item)) {
                        re[map.get("len")] = item;
                        index++;
                    }
                    map.put("len", map.get("len") + index);
                }
        );
        //将re中初始化为0的位置去除
        return Arrays.copyOf(re, map.get("len"));
    }

    /**
     * @Description 快乐数
     * @author gexx
     * @Date 2020/3/1
     **/
    public static boolean isHappy(int n) {
        // Write your code here
        if (n == 1) {
            return true;
        }
        if (n < 1) {
            return false;
        }
        int count = 0;
        while (n != 1) {
            String s = n + "";
            char[] arr = s.toCharArray();
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i] + "") * Integer.parseInt(arr[i] + "");
            }
            n = sum;
            count++;
            if (count > 1000) {
                return false;
            }
        }
        return true;


    }

    /**
     * @Description: 同构字符串
     * @Author: gexx
     * @Date: 2020/3/3
     **/
    public static boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.indexOf(ch1[i]) != t.indexOf(ch2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 两个列表的最小索引总和
     * @Author: gexx
     * @Date: 2020/3/3
     **/
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList<String>());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key : map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }

    /**
     * @Description: 存在重复元素 II
     * @Author: gexx
     * @Date: 2020/3/3
     **/


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return false;
        if (n <= 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null && (i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @Description寻找重复的子树
     * @Author gexx
     * @Date 2020/3/3
     **/
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        DLR(root, map, list);
        return list;
    }

    public String DLR(TreeNode node, HashMap<String, Integer> map, List<TreeNode> list) {

        if (node == null) {
            return "";
        }
        String str = node.val + "(" + DLR(node.right, map, list) + ")" + "(" + DLR(node.left, map, list) + ")";

        if (map.containsKey(str)) {
            if (map.get(str) == 1) {
                list.add(node);
            }
            map.put(str, map.get(str) + 1);

        } else {
            map.put(str, 1);
        }
        return str;

    }

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        String s = "aab", t = "ccb";
        System.out.println(isIsomorphic(s, t));


        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"},
                list2 = {"KFC", "Shogun", "Burger King"};

        int[] nums = {1, 2, 3, 1};
        int k = 3;
        containsNearbyDuplicate(nums, k);
    }
}