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
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        recursion(root, list);
        return list;
    }

    public static void recursion(TreeNode root, List<Integer> list) {
        if (root == null) return;
        else {
            list.add(root.val);
            recursion(root.left, list);
            recursion(root.right, list);
        }
    }

    /**
     * 路径总和
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum = sum - root.val;
        if (root.left == null && root.right == null)
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /**
     * @Description: 从中序与后序遍历序列构造二叉树
     * @Author: gexx
     * @Date: 2020/4/8
     **/
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int instart = 0, inend = inorder.length - 1;
        int poststart = 0, postend = postorder.length - 1;
        if (postorder == null || postend == -1) return null;
        return create(inorder, instart, inend, postorder, poststart, postend);
    }

    public TreeNode create(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (postend < poststart || instart > inend) return null;
        int value = postorder[postend]; //后续遍历的最后一个节点作为根节点，记录值
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) { //后序遍历的最后一个节点在中序遍历中的位子。
            if (value == inorder[i]) {
                mid = i;
            }
        }
        int num = mid - instart;   //记录左子树节点个数,后面用于构造子树时 数组区间下标设置。
        TreeNode root = new TreeNode(value);
        root.left = create(inorder, instart, mid - 1, postorder, poststart, poststart + num - 1);
        root.right = create(inorder, mid + 1, inend, postorder, poststart + num, postend - 1);
        return root;
    }
}
