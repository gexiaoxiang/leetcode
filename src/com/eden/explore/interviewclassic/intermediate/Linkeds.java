package com.eden.explore.interviewclassic.intermediate;

/**
 * @Description: 链表相关算法
 * @Author gexx
 * @Date 2019/12/17
 * @Version V1.0
 **/
public class Linkeds {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 两数相加
     * @Param: [l1, l2]
     * @Return: com.eden.explore.interviewclassic.intermediate.Linkeds.ListNode
     * @Author: gexx
     * @Date: 2019/12/17
     **/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义满十进一的数
        int num = 0;
        //定义一个ListNode，作为链表头
        ListNode proNode = new ListNode(0);
        //定义一个ListNode，接受两数的和
        ListNode currentNode = new ListNode(0);
        //先连接两个Node
        proNode.next = currentNode;

        do {
            //两数相加
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + num;
            //是否满十
            num = sum / 10;
            //得出个位数
            int result = sum % 10;
            //填入结果
            currentNode.val = result;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            if (l1 != null || l2 != null || num != 0) {
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            }
        } while (l1 != null || l2 != null || num != 0);
        return proNode.next;

    }

    /**
     * @Description: 奇偶链表
     * @Param: [head]
     * @Return: com.eden.explore.interviewclassic.intermediate.Linkeds.ListNode
     * @Author: gexx
     * @Date: 2019/12/18
     **/
    public static ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode odd=head,even=head.next,evenhead=even;
        while(odd.next!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        ListNode listNode = addTwoNumbers(l1, l4);
        System.out.print(listNode);
    }

}


