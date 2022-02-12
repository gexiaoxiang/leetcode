package com.eden.explore.speciallecture;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 递归
 * @Author gexx
 * @Date 2020/4/29
 * @Version V1.0
 **/
public class Recursion {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        /**
         * @Description: 两两交换链表中的节点
         * @Author: gexx
         * @Date: 2020/4/29
         **/

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode ans = head.next;
            ListNode temp = swapPairs(head.next.next);
            ans.next = head;
            head.next = temp;
            return ans;
        }

        /**
         * 第K个语法符号
         *
         * @Author: gexx
         * @Date: 2020/4/29
         **/


        public int kthGrammar(int z, int k) {
            if (z == 1) {
                return 0;
            }
            return (~k & 1) ^ kthGrammar(z - 1, (k + 1) / 2);
        }
    }

    /**
     * @Description: 不同的二叉搜索树 II
     * @Author: gexx
     * @Date: 2020/4/29
     **/

    public LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left_trees = generateTrees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right_trees = generateTrees(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }
}
