package com.eden.primary;

import java.util.LinkedList;

/**
 * @Description: 树
 * @Author gexx
 * @Date 2019/11/8
 * @Version V1.0
 **/
public class Trees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 二叉树的最大深度
     * @Param: [root]
     * @Return: int
     * @Author: gexx
     * @Date: 2019/11/8
     **/
    public int maxDepth(TreeNode root) {


        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
