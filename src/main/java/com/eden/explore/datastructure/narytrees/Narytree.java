package com.eden.explore.datastructure.narytrees;

import java.util.ArrayList;
import java.util.List;

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

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
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
}
