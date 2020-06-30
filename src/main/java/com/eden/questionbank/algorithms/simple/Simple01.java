package com.eden.questionbank.algorithms.simple;

/**
 * @Description: 简单
 * @Author gexx
 * @Date 2020/6/30
 * @Version V1.0
 **/
public class Simple01 {
    /**
     * @Description: 最后一个单词的长度
     * @Author: gexx
     * @Date: 2020/6/30
     **/
    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) return 0;
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 删除排序链表中的重复元素
     * @Author: gexx
     * @Date: 2020/6/30
     **/
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        deleteDuplicates(listNode1);
    }
}
