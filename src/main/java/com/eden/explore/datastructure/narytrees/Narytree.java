package com.eden.explore.datastructure.narytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: N叉树
 * @Author gexx
 * @Date 2020/4/10
 * @Version V1.0
 **/
public class Narytree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            val = val;
        }

        public Node(int val, List<Node> children) {
            val = val;
            children = children;
        }
    }

    /**
     * @Description: N-ary Tree Preorder Traversal
     * @Author: gexx
     * @Date: 2020/4/16
     **/
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<Integer>();
        getValue(root, list);
        return list;
    }

    public List<Integer> getValue(Node root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        list.add(root.val);
        if (root.children != null) {
            for (Node n : root.children) {
                getValue(n, list);
            }
        }
        return list;
    }

    /**
     * @Description: N-ary Tree Postorder Traversal
     * @Author: gexx
     * @Date: 2020/4/29
     **/
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrder(res, root);
        return res;
    }

    public void postOrder(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            postOrder(res, node);
        }
        res.add(root.val);

    }

    /**
     * @Description: N叉树的层序遍历
     * @Author: gexx
     * @Date: 2020/4/29
     **/

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().children != null) {
                    for (int j = 0; j < queue.peek().children.size(); j++) {
                        queue.offer(queue.peek().children.get(j));
                    }
                }
                list.add(queue.poll().val);
            }
            result.add(list);
        }
        return result;
    }

    /**
     * @Description: Maximum Depth of N-ary Tree
     * @Author: gexx
     * @Date: 2020/4/29
     **/
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            res++;
            for (int i = 0; i < levelNum; i++) {
                Node tmp = queue.poll();
                if (tmp.children != null) {
                    List<Node> child = tmp.children;
                    for (Node ele : child) {
                        queue.add(ele);
                    }
                }
            }
        }
        return res;
    }
}
