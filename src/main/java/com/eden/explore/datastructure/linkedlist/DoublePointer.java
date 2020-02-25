package com.eden.explore.datastructure.linkedlist;

/**
 * @Description: 双指针
 * @Author gexx
 * @Date 2020/2/25
 * @Version V1.0
 **/
public class DoublePointer {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @Description: 环形链表 II
     * @Author: gexx
     * @Date: 2020/2/25
     **/
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == slow) {
            ListNode q = head;
            while (q != slow) {
                q = q.next;
                slow = slow.next;
            }
            return q;
        } else {
            return null;
        }

    }
}
