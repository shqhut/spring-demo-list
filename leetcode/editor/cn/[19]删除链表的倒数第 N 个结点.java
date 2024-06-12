
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 链表解题技巧，虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        // 删除倒数第k个结点，需要先找到倒数第k+1个结点
        for (int i = 0; i < n+1; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
