package com.eden.explore.datastructure.linkedlist;

/**
 * @Description: 经典问题
 * @Author gexx
 * @Date 2020/2/25
 * @Version V1.0
 **/
public class ClassicalProblem {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 移除链表元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;

    }
}