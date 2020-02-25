package com.eden.explore.datastructure.linkedlist;

/**
 * @Description: 小结
 * @Author gexx
 * @Date 2020/2/25
 * @Version V1.0
 **/
public class Summary {
    class Solution1 {
        /**
         * 扁平化多级双向链表
         */
        class Node {
            public int val;
            public Node prev;
            public Node next;
            public Node child;
        }

        public Node flatten(Node head) {
            Node cur = head;
            while (cur != null) {
                if (cur.child == null) {
                    cur = cur.next;
                    continue;
                }
                Node child = cur.child;
                Node childTail = child;
                cur.child = null;
                child.prev = cur;

                while (childTail.next != null)
                    childTail = childTail.next;
                childTail.next = cur.next;
                if (cur.next != null)
                    cur.next.prev = childTail;
                cur.next = child;
                cur = cur.next;
            }
            return head;

        }


    }
}

