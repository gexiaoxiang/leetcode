package com.eden.explore.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二叉树
 * @Author gexx
 * @Date 2020/4/7
 * @Version V1.0
 **/
public class BinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉树的前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list=new ArrayList<>();
            if(root==null) return list;
            recursion(root,list);
            return list;
        }
        public static void recursion(TreeNode root,List<Integer> list){
            if(root==null) return;
            else{
                list.add(root.val);
                recursion(root.left,list);
                recursion(root.right,list);
            }
        }
}
