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

    /**
     * 复制带随机指针的链表
     */
    class Solution2 {
        class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Node ptr = head;
            while (ptr != null) {

                // Cloned node
                Node newNode = new Node(ptr.val);

                newNode.next = ptr.next;
                ptr.next = newNode;
                ptr = newNode.next;
            }
            ptr = head;
            while (ptr != null) {
                ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
                ptr = ptr.next.next;
            }
            Node ptr_old_list = head; // A->B->C
            Node ptr_new_list = head.next; // A'->B'->C'
            Node head_old = head.next;
            while (ptr_old_list != null) {
                ptr_old_list.next = ptr_old_list.next.next;
                ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
                ptr_old_list = ptr_old_list.next;
                ptr_new_list = ptr_new_list.next;
            }
            return head_old;
        }

    }


}

