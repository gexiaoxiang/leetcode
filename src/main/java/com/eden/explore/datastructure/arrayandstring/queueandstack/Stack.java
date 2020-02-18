package com.eden.explore.datastructure.arrayandstring.queueandstack;

import java.util.*;

/**
 * @Description: 栈：后入先出的数据结构
 * @Author gexx
 * @Date 2020/2/14
 * @Version V1.0
 **/
public class Stack {

    /**
     * 最小栈
     */
    static class MinStack {

        private java.util.Stack<Integer> data;
        private java.util.Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new java.util.Stack();
            minStack = new java.util.Stack();
        }

        public void push(int x) {
            data.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }

        }

        public void pop() {
            int x = data.pop();
            if (!minStack.isEmpty() && minStack.peek().equals(x)) {
                minStack.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

        public static void main(String[] args) {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin();
            minStack.pop();
            minStack.top();
            minStack.getMin();
        }
    }

    /**
     * @Description 每日温度
     * @author gexx
     * @Date 2020/2/15
     **/
    public static int[] dailyTemperatures(int[] T) {
        int re[] = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            int count = 0;
            for (int x = i; x < T.length - 1; x++) {
                count++;
                if (T[i] >= T[x + 1]) {
                } else {
                    re[i] = count;
                    break;
                }
            }


        }

        return re;
    }

    /**
     * @Description 逆波兰表达式求值
     * @Author gexx
     * @Date 2020/2/15
     **/
    public static int evalRPN(String[] tokens) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        int num1 = 0, num2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 + num1);
            } else if (s.equals("-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (s.equals("*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (s.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    /**
     * @Description 岛屿数量-深度優先
     * @Author gexx
     * @Date 2020/2/17
     **/
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int l = grid[0].length;
        char[][] vist = new char[row][l];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < l; j++) {
                if (vist[i][j] != '1' && grid[i][j] == '1') //如果没有访问过，且为陆地，计数加1。
                {
                    count++;
                }
                FS(grid, vist, i, j); //遍历这个区域周围，将与自己相连的区域 vist全置为1(相连接的 1 为一块)
            }
            //继续下一个位子
        }
        return count;
    }

    //将与这个1相连所有区域全部置为访问过。
    public static void FS(char[][] grid, char[][] vist, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return;
        }
        if (grid[i][j] == '0') { //访问到海洋返回
            return;
        }
        if (vist[i][j] == '1') { //访问过的陆地 返回。
            return;
        }
        //没访问过 先置1
        vist[i][j] = '1';
        //上下左右遍历
        FS(grid, vist, i + 1, j);
        FS(grid, vist, i - 1, j);
        FS(grid, vist, i, j + 1);
        FS(grid, vist, i, j - 1);
        return;

    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * @Description 克隆图
     * @Author gexx
     * @Date 2020/2/18
     **/
    public Node cloneGraph(Node node) {

        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<Node, Node>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (Node tmp : now.neighbors) {
                if (!lookup.containsKey(tmp)) {
                    lookup.put(tmp, new Node(tmp.val, new ArrayList<>()));
                    queue.offer(tmp);
                }
                lookup.get(now).neighbors.add(lookup.get(tmp));
            }
        }

        return clone;
    }


    public static void main(String[] args) {
        int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        String tokens[] = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
}


