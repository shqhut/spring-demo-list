package com.shq.demo.dataStructure.每日一题.删除链表中的重复元素ll;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 给定一个已排序的链表的头head，删除原始链表中所有重复数字的节点，
     * 只留下不同的数字。返回已排序的链表。
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        Map<Integer,Integer> countMap = new HashMap<>();
        ListNode p = head;
        while (p.next != null) {
            countMap.put(p.val, countMap.getOrDefault(p.val,0) + 1);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (countMap.get(p.val) == 1) {
                node.next = new ListNode(p.val);
                node = node.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

}

/**
 * Definition for singly-linked list.
 **/
class ListNode {
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

