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

}
