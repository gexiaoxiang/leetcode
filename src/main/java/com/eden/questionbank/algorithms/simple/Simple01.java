package com.eden.questionbank.algorithms.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 简单
 * @Author gexx
 * @Date 2020/6/30
 * @Version V1.0
 **/
public class Simple01 {
    /**
     * @Description: 最后一个单词的长度
     * @Author: gexx
     * @Date: 2020/6/30
     **/
    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) return 0;
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 删除排序链表中的重复元素
     * @Author: gexx
     * @Date: 2020/6/30
     **/
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 相同的树
     * @Author: gexx
     * @Date: 2020/7/1
     **/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);

    }

    /**
     * @Description: 二叉树的层次遍历 II
     * @Author: gexx
     * @Date: 2020/7/2
     **/
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // 在索引 0 的位置加入一维数组 tmp
            // 每次新的数组进来都会被放在开始的位置
            ans.add(0, tmp);
        }
        return ans;
    }

    /**
     * @Description: 111. 二叉树的最小深度
     * @Author: gexx
     * @Date: 2020/7/2
     **/
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }


        return minDepth + 1;

    }

    /**
     * @Description: Excel表列名称
     * @Author: gexx
     * @Date: 2020/7/3
     **/
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                c = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }
        return sb.toString();
    }

    /**
     * @Description: 翻转二叉树
     * @Author: gexx
     * @Date: 2020/7/3
     **/
    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        deleteDuplicates(listNode1);

        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        root.right.left = l2;
        root.right.right = r2;
        levelOrderBottom(root);
        minDepth(root);

        invertTree(root);

    }
}
