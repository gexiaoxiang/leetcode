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
                    if (!map.containsKey(i + j)) {
                        map.put(i + j, new ArrayList<String>());
                    }
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int minIndexSum = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            minIndexSum = Math.min(minIndexSum, key);
        }
        String[] res = new String[map.get(minIndexSum).size()];
        return map.get(minIndexSum).toArray(res);
    }

    /**
     * @Description: 存在重复元素 II
     * @Author: gexx
     * @Date: 2020/3/3
     **/


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return false;
        }
        if (n <= 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null && (i - map.get(nums[i])) <= k) {
                return true;
            }
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
        dlr(root, map, list);
        return list;
    }

    public String dlr(TreeNode node, HashMap<String, Integer> map, List<TreeNode> list) {

        if (node == null) {
            return "";
        }
        String str = node.val + "(" + dlr(node.right, map, list) + ")" + "(" + dlr(node.left, map, list) + ")";

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

    /**
     * @Description 宝石与石头
     * @author gexx
     * @Date 2020/3/3
     **/
    public static int numJewelsInStones(String j, String s) {
        char[] js = j.toCharArray();
        char[] ss = s.toCharArray();
        int count = 0;
        for (int i = 0; i < js.length; i++) {
            for (int i1 = 0; i1 < ss.length; i1++) {
                if (js[i] == (ss[i1])) {
                    count++;
                }
            }
        }


        return count;
    }

    /**
     * @Description: 四数相加 II
     * @Author: gexx
     * @Date: 2020/3/4
     **/


    public static int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sumab = a[i] + b[j];
                if (map.containsKey(sumab)) {
                    map.put(sumab, map.get(sumab) + 1);
                } else {
                    map.put(sumab, 1);
                }
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int sumcd = -(c[i] + d[j]);
                if (map.containsKey(sumcd)) {
                    res += map.get(sumcd);
                }
            }
        }
        return res;

    }

    /**
     * @Description前 K 个高频元素
     * @author gexx
     * @Date 2020/3/4
     **/
    public static List<Integer> topkfrequent(int[] nums, int k) {
        // 统计元素的频次
        Map<Integer, Integer> int2FreqMap = new HashMap<>(16);
        for (int num : nums) {
            int2FreqMap.put(num, int2FreqMap.getOrDefault(num, 0) + 1);
        }
        // 桶排序
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer key : int2FreqMap.keySet()) {
            int freq = int2FreqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // 逆序（频次由高到低）取出元素
        List<Integer> ret = new ArrayList<>();
        for (int i = nums.length; i >= 0 && ret.size() < k; --i) {
            if (bucket[i] != null) {
                ret.addAll(bucket[i]);
            }
        }

        return ret;

    }

    /**
     * @Description 常数时间插入、删除和获取随机元素
     * @Author gexx
     * @Date 2020/3/4
     **/
    class RandomizedSet {

        HashSet<Integer> set;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            set = new HashSet<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            return set.add(val);
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            return set.remove(val);
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Object[] list = set.toArray();
            int length = list.length;
            int index = (int) (Math.random() * length);
            return (Integer) list[index];
        }
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
        String j = "aA", abbbb = "aAAbbbb";
        System.out.println(numJewelsInStones(j, abbbb));
        int[]
                a = {1, 2},
                b = {-2, -1},
                c = {-1, 2},
                d = {0, 2};

        fourSumCount(a, b, c, d);

        int[] nums11 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        topkfrequent(nums11, k1);

    }
}