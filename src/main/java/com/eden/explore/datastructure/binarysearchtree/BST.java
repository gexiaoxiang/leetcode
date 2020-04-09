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
            TreeNode n=stack.pop();
            TreeNode cur=n.right;
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            return n.val;
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
/**
  * @Description: TODO

  * @Author: gexx
  * @Date: 2020/4/9
  **/


    public TreeNode searchBST(TreeNode root, int val) {

    }
}
