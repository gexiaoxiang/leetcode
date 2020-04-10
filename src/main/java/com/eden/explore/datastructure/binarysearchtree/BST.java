package com.eden.explore.datastructure.binarysearchtree;

import java.util.LinkedList;

/**
 * @Description: 二叉搜索树
 * @Author gexx
 * @Date 2020/4/9
 * @Version V1.0
 **/
public class BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class BSTIterator {
        LinkedList<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }


        public int next() {
            TreeNode n = stack.pop();
            TreeNode cur = n.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return n.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    /**
     * @Description: Search in a Binary Search Tree
     * @Author: gexx
     * @Date: 2020/4/9
     **/
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) return null;
        while (root != null) {
            if (root.val < val) {
                root = root.right;
            } else if (root.val > val) {
                root = root.left;
            } else {
                return root;
            }
        }

        return null;
    }

    /**
     * @Description: Insert into a Binary Search Tree
     * @Author: gexx
     * @Date: 2020/4/9
     **/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
    /**
      * @Description: Delete Node in a BST

      * @Author: gexx
      * @Date: 2020/4/10
      **/
        public TreeNode deleteNode(TreeNode root, int key) {

    }
}
