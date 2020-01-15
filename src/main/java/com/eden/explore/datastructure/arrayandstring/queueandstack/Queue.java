package com.eden.explore.datastructure.arrayandstring.queueandstack;

/**
 * @Description: 队列：先入先出的数据结构
 * @Author gexx
 * @Date 2020/1/9
 * @Version V1.0
 **/
public class Queue {
    static class MyCircularQueue {
        int[] queue;
        int count, front, rear;

        public MyCircularQueue(int k) {
            queue = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;
            queue[rear] = value;
            rear = (rear + 1) % queue.length;
            count++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;
            front = (front + 1) % queue.length;
            count--;
            return true;
        }

        public int Front() {
            if (isEmpty())
                return -1;
            return queue[front];
        }

        public int Rear() {
            if (isEmpty())
                return -1;
            return rear == 0 ? queue[queue.length - 1] : queue[rear - 1];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == queue.length;
        }
    }

    /**
     * @Description: 岛屿数量
     * @Param: [grid]
     * @Return: int
     * @Author: gexx
     * @Date: 2020/1/15
     **/
    public int numIslands(char[][] grid) {

        int x = grid.length;//行
        //边界条件
        int counts_island = 0;
        if (grid != null && x > 0) {
            int y = grid[0].length;//列
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == '1') {
                        DFS(i, j, grid);
                        counts_island++;
                    }
                }
            }
        }
        return counts_island;
    }

    public void DFS(int i, int j, char[][] grid) {
        //递归结束条件
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
            return;
        }
        if (grid[i][j] == '1') {
            //中心位置重置
            grid[i][j] = '2';
            //上
            DFS(i - 1, j, grid);
            //下
            DFS(i + 1, j, grid);
            //左
            DFS(i, j - 1, grid);
            //右
            DFS(i, j + 1, grid);
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        MyCircularQueue m = new MyCircularQueue(3);
        m.enQueue(1);
        m.enQueue(2);
        m.enQueue(3);
        m.enQueue(4);
        m.deQueue();

    }

}
