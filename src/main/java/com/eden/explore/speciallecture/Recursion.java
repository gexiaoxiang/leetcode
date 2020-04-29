package com.eden.explore.speciallecture;

/**
 * @Description: 递归
 * @Author gexx
 * @Date 2020/4/29
 * @Version V1.0
 **/
public class Recursion {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 两两交换链表中的节点
     * @Author: gexx
     * @Date: 2020/4/29
     **/

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode ans = head.next;
        ListNode temp = swapPairs(head.next.next);
        ans.next = head;
        head.next = temp;
        return ans;
    }

    /**
     * 第K个语法符号
     *
     * @Author: gexx
     * @Date: 2020/4/29
     **/


    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
    }
}
