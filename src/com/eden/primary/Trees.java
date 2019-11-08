package com.eden.primary;

import java.util.*;

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

    /**
     * @Description: 二叉树的层次遍历
     * @Param: [root]
     * @Return: List<List   <   Integer>>
     * @Author: gexx
     * @Date: 2019/11/8
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    /**
     * @Description: 将有序数组转换为二叉搜索树
     * @Param: [nums]
     * @Return: com.eden.primary.Trees.TreeNode
     * @Author: gexx
     * @Date: 2019/11/8
     **/
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);

    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;                                        //边界条件，注意是left>right
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);        //递归向左探索，范围变成left~mid-1;
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
