package com.eden.explore.datastructure.binarysearchtree;

import java.util.HashSet;
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
    public TreeNode searchBst(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
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
    public TreeNode insertIntoBst(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBst(root.left, val);
        } else {
            root.right = insertIntoBst(root.right, val);
        }

        return root;
    }

    /**
     * @Description: Delete Node in a BST
     * @Author: gexx
     * @Date: 2020/4/10
     **/
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            int min = findMin(root.right);
            root.val = min;
            root.right = deleteNode(root.right, min);
        }
        return root;
    }

    private int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    /**
     * @Description: 二叉搜索树的最近公共祖先
     * @Author: gexx
     * @Date: 2020/4/10
     **/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                //都比根节点值小，去根节点的左子树继续找
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                //都比根节点值大，去根节点的右子树继续找
                root = root.right;
            } else {
                //根节点的值大于p而小于q，说明此时的根节点即为最近公共祖先。
                return root;
            }
        }
        return null;
    }

    /**
     * @Description: 存在重复元素 III
     * @Author: gexx
     * @Date: 2020/4/10
     **/

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashSet<Long> set = new HashSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            if ((long) t == 0) {
                if (set.contains((long) nums[i])) {
                    return true;
                }
            } else {
                for (Long num : set) {
                    if (Math.abs(num - nums[i]) <= t) {
                        return true;
                    }
                }

            }
            set.add((long) nums[i]);
            //set 始终保持k大小
            if (set.size() > k) { // 大于k时候，删除数组中最左端值
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * @Description: 平衡二叉树
     * @Author: gexx
     * @Date: 2020/4/10
     **/
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int depth(TreeNode root) {//求深度
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
