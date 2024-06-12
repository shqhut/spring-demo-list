package com.shq.demo.dataStructure.数组链表;

import java.util.PriorityQueue;

public class 合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        // 操作链表的指针
        ListNode p = dummy;

        // 借助PriorityQueue获取最小头节点
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((x,y) -> x.val-y.val);
        for (ListNode head : lists){
            priorityQueue.add(head);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            if (p.next != null) {
                priorityQueue.add(p.next);
            }
            p = p.next;
        }
        return dummy.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
