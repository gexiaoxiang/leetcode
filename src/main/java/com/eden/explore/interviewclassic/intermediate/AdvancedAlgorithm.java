package com.eden.explore.interviewclassic.intermediate;

import java.util.*;

/**
 * @Description: Advanced algorithm
 * @Author gexx
 * @Date 2020/6/22
 * @Version V1.0
 **/
public class AdvancedAlgorithm {
    /**
     * @Description: 除自身以外数组的乘积
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int n1[] = new int[n];
        int n2[] = new int[n];
        n1[0] = 1;
        n2[0] = 1;
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            n1[i] = nums[i - 1] * n1[i - 1];
            n2[i] = nums[n - i] * n2[i - 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = n1[i] * n2[n - i - 1];
        }
        return result;

    }

    /**
     * @Description: 生命游戏
     * @Author: gexx
     * @Date: 2020/6/22
     **/
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        int rows = board.length;
        int cols = board[0].length;
        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //用于记录这个格子的四周有几个存活的细胞
                int count = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                count++;
                            }
                        }
                    }
                }
                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (count < 2 || count > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && count == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }
        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    /**
     * @Description: 缺失的第一个正数
     * @Author: gexx
     * @Date: 2020/6/24
     **/
    public static int firstMissingPositive(int[] nums) {
        boolean[] verify = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] < verify.length) {
                    verify[nums[i]] = true;
                }
            }
        }
        for (int i = 1; i < verify.length; i++) {
            if (verify[i] == false) {
                return i;
            }
        }
        return verify.length;
    }

    /**
     * @Description: 最长连续序列
     * @Author: gexx
     * @Date: 2020/6/28
     **/
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }

    /**
     * @Description: 基本计算器 II
     * @Author: gexx
     * @Date: 2020/6/29
     **/
    public static int calculate(String s) {
        int result = 0, len = s.length(), num = 0;
        char op = '+';  //初始上一个运算符为加法 上个数字为0
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0') {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (c < '0' && c != ' ' || i == len - 1) {
                if (op == '+') stack.push(num);
                if (op == '-') stack.push(-num);
                if (op == '*' || op == '/') {
                    int temp = (op == '*') ? stack.pop() * num : stack.pop() / num;
                    stack.push(temp);
                }
                op = s.charAt(i);
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if ((i + 1) >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    /**
     * @Description: 最小覆盖子串
     * @Author: gexx
     * @Date: 2020/6/29
     **/
    public String minWindow(String s, String t) {


        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        /**
         * 合并K个元素的有序链表
         *
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                while (list != null) {
                    int val = list.val;
                    arr.add(val);
                    list = list.next;
                }

            }

            int size = arr.size();
            int[] data = new int[size];
            for (
                    int i = 0;
                    i < size; i++) {
                data[i] = arr.get(i);
            }
            Arrays.sort(data);
            ListNode list1 = new ListNode(0);
            ListNode list2 = list1;
            for (
                    int i = 0;
                    i < size; i++) {
                int m = data[i];
                ListNode k = new ListNode(1);
                k.val = m;
                list1.next = k;
                list1 = list1.next;
            }
            return list2.next;
        }
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        Object d = map.get("d");
        int[] nums = {1, 0, -1};
        longestConsecutive(nums);

        String s = "3+5/2";
        calculate(s);

    }

}
