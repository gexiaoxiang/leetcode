package com.eden.explore.datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
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

    /**
     * @Description: 前序与中序遍历序列构造二叉树
     * @Author: gexx
     * @Date: 2020/4/8
     **/

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        return buildCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildCore(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd) {
        //前序遍历第一个节点是根节点
        int rootValue = preorder[preSt];
        TreeNode root = new TreeNode(rootValue);

        //前序序列只有根节点
        if (preSt == preEnd) {
            return root;
        }
        //遍历中序序列，找到根节点的位置
        int rootInorder = inSt;
        while (inorder[rootInorder] != rootValue && rootInorder <= inEnd) {
            rootInorder++;
        }

        //左子树的长度
        int leftLength = rootInorder - inSt;
        //前序序列中左子树的最后一个节点
        int leftPreEnd = preSt + leftLength;

        //左子树非空
        if (leftLength > 0) {
            //重建左子树
            root.left = buildCore(preorder, preSt + 1, leftPreEnd, inorder, inSt, inEnd);
        }
        //右子树非空
        if (leftLength < preEnd - preSt) {
            //重建右子树
            root.right = buildCore(preorder, leftPreEnd + 1, preEnd, inorder, rootInorder + 1, inEnd);
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * @Description: 填充每个节点的下一个右侧节点指针
     * @Author: gexx
     * @Date: 2020/4/8
     **/

    public Node connect(Node root) {
        if (root == null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node next = null;
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur.right != null)
                    queue.add(cur.right);
                if (cur.left != null)
                    queue.add(cur.left);
                cur.next = next;
                next = cur;
            }
        }
        return root;
    }

    /**
     * @Description: 填充每个节点的下一个右侧节点指针 II java
     * @Author: gexx
     * @Date: 2020/4/8
     **/

    public Node connectII(Node root) {
        if (root == null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node next = null;
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur.right != null)
                    queue.add(cur.right);
                if (cur.left != null)
                    queue.add(cur.left);
                cur.next = next;
                next = cur;
            }
        }
        return root;
    }

    /**
     * @Description: 二叉树的最近公共祖先
     * @Author: gexx
     * @Date: 2020/4/8
     **/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    /**
     * @Description: 二叉树的序列化与反序列化
     * @Author: gexx
     * @Date: 2020/4/8
     **/

    public String serialize(TreeNode root) {

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

    }
}
