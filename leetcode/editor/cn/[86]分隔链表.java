
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
    public ListNode partition(ListNode head, int x) {
        // 操作链表技巧：借助虚拟头节点
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        // 操作链表的指针
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        // 遍历链表
        // head 1 -> 2 -> 3
        ListNode p = head;
        while(p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 指针移动
            // 将head链表操作过的结点的next指针置为空
            // 分隔链表的时候要注意清空原链表结点的next指针，防止链表成环
//            ListNode temp = p.next;
//            p.next = null;
//            p = temp;
            p = p.next;
        }
        // 防止链表成环
        p1.next = null;
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
