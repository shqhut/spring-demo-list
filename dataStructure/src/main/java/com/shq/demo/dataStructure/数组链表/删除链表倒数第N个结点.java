package com.shq.demo.dataStructure.数组链表;

import java.util.HashSet;

public class 删除链表倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 链表如何定位到倒数第n个节点
        ListNode p = head;
        // 获取链表长度
        int i = 0;
        while (p != null) {
            i++;
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p1 = dummy;
        ListNode p2 = head;
        if (n == 1) {
            p1.next = p2;
        } else {
            for (int x = 0; x < i-n; x++) {
                p1.next = p2;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        // 此时p1.next为倒数第n个节点
        ListNode temp = p1.next;
        p1.next = temp.next;
        return dummy.next;
    }

    public int removeDuplicates(int[] nums) {
        // 借助hashset
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i:nums) {
            hashSet.add(i);
        }
        Integer[] array = hashSet.toArray(new Integer[0]);
        return array.length;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[slow] != nums[i]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        System.out.println(slow);
        for (int y = 0; y <= slow; y++) {
            System.out.print(nums[y]);
        }

    }

}
