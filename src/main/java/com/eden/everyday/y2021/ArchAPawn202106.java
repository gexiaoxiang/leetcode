package com.eden.everyday.y2021;


/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/6/5
 * @Version V1.0
 **/
public class ArchAPawn202106 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

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
