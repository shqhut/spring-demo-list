
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 思路：链表相交，headA.next == headB.next
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            // p1走一步，如果走到A链表末尾，转到B链表
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // p2走一步，如果走到B链表末尾，转到A链表
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
