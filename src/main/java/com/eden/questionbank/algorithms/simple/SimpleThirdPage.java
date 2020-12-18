package com.eden.questionbank.algorithms.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /**
     * @Description: 山脉数组的峰顶索引
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static int peakIndexInMountainArray(int[] arr) {
        int top = -1;
        int topIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > top) {
                top = arr[i];
                topIndex = i;
            } else {
                return topIndex;
            }


        }
        return topIndex;
    }

    /**
     * @Description: 859. 亲密字符串
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c : count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }


    /**
     * @Description: 867. 转置矩阵
     * @Author: gexx
     * [1,2,3]     [1,4,7]
     * [4,5,6]     [2,5,8]
     * [7,8,9]     [3,6,9]
     * <p>
     * [1,2,3] [1,4]
     * [4,5,6] [2,5]
     * [3,6]
     * @Date: 2020/12/17
     **/
    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;

    }


    /**
     * @Description: 868. 二进制间距
     * @Author: gexx
     * @Date: 2020/12/17
     **/
    public static int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                list.add(i);
            }
        }
        if (list.size() <= 1) return 0;
        int max = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(list.get(i + 1) - list.get(i), max);
        }
        return max;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @Description: 872. 叶子相似的树
     * @Author: gexx
     * @Date: 2020/12/17
     **/
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();


        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);


    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            dfs(node.left, list);
            dfs(node.right, list);

        }
    }

    /**
     * @Description: 874. 模拟行走机器人
     * @Author: gexx
     * @Date: 2020/12/18
     **/
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle : obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        binaryGap(22);
        peakIndexInMountainArray(new int[]{0, 1, 0});
        buddyStrings("ab", "ba");
    }
}
