package com.shq.demo.dataStructure.数组链表;

import java.util.PriorityQueue;

public class MergeListNode {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
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

    public static void main(String[] args) {
        MergeListNode mergeListNode = new MergeListNode();

        ListNode node3  = new ListNode(7,null);
        ListNode node2  = new ListNode(6,node3);
        ListNode node1 = new ListNode(5,node2);

        ListNode node5  = new ListNode(8,null);
        ListNode node4  = new ListNode(10,node5);

//        ListNode listNode = mergeListNode.mergeTwoLists(node1, node4);
//        System.out.println(listNode);

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((x,y) -> x.val - y.val);
        priorityQueue.add(node1);
        priorityQueue.add(node4);
        priorityQueue.add(node2);
        ListNode poll = priorityQueue.poll();
        ListNode poll1 = priorityQueue.poll();
        System.out.println(poll.val);
        System.out.println(poll1.val);
    }


}


