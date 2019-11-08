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

    /**
     * @Description: 验证二叉搜索树
     * @Param: [root]
     * @Return: boolean
     * @Author: gexx
     * @Date: 2019/11/8
     **/
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            if (cur.val >= root.val) {
                return false;
            }
        }

        if (root.right != null) {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            if (cur.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);


    }

    /**
     * @Description: 对称二叉树
     * @Param: [root]
     * @Return: boolean
     * @Author: gexx
     * @Date: 2019/11/8
     **/
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return judge(root.left, root.right);
    }

    boolean judge(TreeNode left, TreeNode right) {
        // 左子树和右子树都是空
        if (left == null && right == null) {
            return true;
        }
        // 左子树空，右子树非空
        if (left == null && right != null) {
            return false;
        }
        // 右子树空，左子树非空
        if (right == null && left != null) {
            return false;
        }
        // 左右字子树不相等
        if (left.val != right.val) {
            return false;
        }
        // 左右子树值相等，则判断其下层节点
        if (left.val == right.val) {
            return judge(left.left, right.right) && judge(left.right, right.left);
        }
        return true;
    }

}
