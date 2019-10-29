package com.eden.primary;

/**
 * @Description: 链表相关算法
 * @Author gexx
 * @Date 2019/10/25
 * @Version V1.0
 **/
public class Linkeds {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 删除链表中的节点
     * @Param: [node]
     * @Return: void
     * @Author: gexx
     * @Date: 2019/10/25
     **/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    /**
     * @Description: 删除链表的倒数第N个节点
     * @Param: [head, n]
     * @Return: com.eden.primary.Linkeds.ListNode
     * @Author: gexx
     * @Date: 2019/10/28
     **/
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode right = head;
        ListNode left = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            head = head.next;
            return head;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;

    }

    /**
     * @Description: 反转链表
     * @Param: [head]
     * @Return: com.eden.primary.Linkeds.ListNode
     * @Author: gexx
     * @Date: 2019/10/29
     **/
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        while (null != head.next) {
            ListNode pre = null, cur = head, next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;

        }


        return head;
    }

}
