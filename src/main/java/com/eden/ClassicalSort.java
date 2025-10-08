package com.eden;

import java.util.*;

/**
 * @Description: 经典排序
 * @Author gexx
 * @Date 2021/4/12
 * @Version V1.0
 **/
public class ClassicalSort {


    /**
     * @Description: 冒泡排序
     * @Author: gexx
     * @Date: 2021/4/12
     **/
    public static int[] BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {

                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    /**
     * @Description: 选择排序
     * @Author: gexx
     * @Date: 2021/4/13
     **/
    public static int[] SelectionSort(int[] arr) {
        int minIndex, tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return arr;
    }

    /**
     * @Description: 插入排序
     * @Author: gexx
     * @Date: 2021/4/13
     **/
    public static int[] InsertionSort(int[] arr) {


        return arr;
    }

    public static int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> c = new HashMap();
        for (int num : nums) {
            if (num % 2 == 0) {
                c.put(num, c.getOrDefault(num, 0) + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : c.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                min = entry.getKey();

            } else if (entry.getValue() == count) {
                min = Math.min(min, entry.getKey());
            }
        }

        return min;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int c[] = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0) {
                return false;
            }
        }
        return !s.equals(t);
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        // 创建下标数组，对下标数组排序
        Integer[] idx = new Integer[nums.length];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> nums[j] - nums[i]);

        // 对前 k 个下标排序
        // 注：排序 int[] 比排序 Integer[] 快 2ms
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = idx[i];
        }
        Arrays.sort(ans);

        // 取出 nums 的子序列
        for (int i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }

    public int[] inventoryManagement1(int[] stock, int cnt) {
        int ans[] = new int[cnt];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });


        for (int e : stock) {
            priorityQueue.add(e);
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            ans[i++] = priorityQueue.poll();
        }
        return ans;

    }

    public static int[] inventoryManagement(int[] stock, int cnt) {
        int[] ans = new int[cnt];
        if (cnt == 0) { // 排除 0 的情况
            return ans;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < cnt; ++i) {
            queue.offer(stock[i]);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }
        return ans;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(parent, edge);
        }
        return find(parent, source) == find(parent, destination);
    }

    private static void union(int[] parent, int[] edge) {
        int rootA = find(parent, edge[0]);
        int rootB = find(parent, edge[1]);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }

    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);  // path compression
        }
        return parent[i];
    }

    public static int minimumPairRemoval(int[] nums) {
        if (isNotSub(nums)) {
            return 0;
        }
        int arr[] = new int[nums.length - 1];
        int minSum = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] + nums[i + 1] < minSum) {
                minSum = nums[i] + nums[i + 1];
                minIndex = i;
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i != minIndex) {
                arr[i] = nums[i];
            } else {
                arr[i] = nums[i] + nums[++i];
            }
        }

        return minimumPairRemoval(arr) + 1;
    }

    public static boolean isNotSub(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int getLeastFrequentDigit(int n) {
        int c[] = new int[10];
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {

            c[s.charAt(i) - '0']++;
        }
        int minF = Integer.MAX_VALUE;
        int min = 9;
        for (int i = 8; i >= 0; i--) {
            if (c[i] < minF && c[i] > 0) {
                minF = c[i];
                min = i;
            }
        }
        return min;

    }


    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        Arrays.sort(nums);

        int L = 1;
        int R = nums.length - 2;
        int sumL = nums[0];
        int sumR = nums[R];
        while (L < R) {
            if (sumL <= sumR) {
                sumL += nums[L++];
            } else {
                sumR += nums[R--];
            }
        }
        return sumL == sumR;
    }

    public static int[] maxKDistinct(int[] nums, int k) {
        List<Integer> ans = new ArrayList();
        Arrays.sort(nums);
        int last = nums[nums.length - 1];
        ans.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (ans.size() == k) {
                break;
            }
            if (last != nums[i]) {
                ans.add(nums[i]);
                last = nums[i];
            }
        }
        int re[] = new int[ans.size()];
        int index = 0;
        for (Integer i : ans) {
            re[index] = i;
        }
        return re;
    }
    public static String reverseMessage(String message) {
        message=message.trim();

        String []messages= message.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i= messages.length-1;i>=0;i--){

            sb.append(messages[i].trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static int diagonalPrime(int[][] nums) {
        int diagonalPrime = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; i < nums[0].length; j++) {
                if ((i == j || j == nums.length - i - 1) && isPrime(nums[i][j])) {
                    diagonalPrime = Math.max(diagonalPrime, nums[i][j]);
                }
            }
        }
        return diagonalPrime;
    }

    // 判断一个数是否为质数（简单方法）
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // 小于等于1的数不是质数
        }
        for (int i = 2; i < num; i++) { // 从2遍历到num-1
            if (num % i == 0) { // 如果能被整除，则不是质数
                return false;
            }
        }
        return true; // 否则是质数
    }
    public static void main(String[] args) {
        diagonalPrime(new int[][]{{1,2,3},{5,6,7},{9,10,11}});
    }
}

