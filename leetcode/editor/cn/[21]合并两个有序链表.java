
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // list1,list2都是升序链表
        // 定义一个虚拟链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;
        // 边界情况考虑，同时遍历两个链表，当一个链表排序完成，另一个链表剩下的元素可以直接连接到后面
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p指针不断前进
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

}
//leetcode submit region end(Prohibit modification and deletion)
