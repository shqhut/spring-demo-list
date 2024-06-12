
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 快慢指针
        ListNode p = head;
        ListNode p1 = head;
        while(p1 != null) {
            if (p.val != p1.val) {
                p.next = p1;
                p = p.next;
            }
            p1 = p1.next;
        }
        // 断开与后面重复元素的连接
        p.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
