package com.shq.demo.dataStructure.栈.重排链表;

import java.util.List;
import java.util.Stack;

/**
 * 重排链表
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        // 借助栈先进后出的特性
        Stack<ListNode> stack = new Stack<>();
        // 操作链表的指针
        ListNode p = head;
        while (p.next != null) {
            stack.push(p);
            p = p.next;
        }

        p = head;
        while (p.next != null) {
            // 链表尾节点
            ListNode lastNode = stack.pop();
            ListNode next = p.next;
            if (lastNode == next || lastNode.next == next) {
                next.next = null;
                break;
            }
            p.next = lastNode;
            lastNode.next = next;
            p = p.next;
        }
    }

}

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
