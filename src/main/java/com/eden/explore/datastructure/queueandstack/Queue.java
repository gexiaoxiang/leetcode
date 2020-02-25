package com.eden.explore.datastructure.queueandstack;

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
