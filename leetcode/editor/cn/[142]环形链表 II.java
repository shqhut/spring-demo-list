
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针处理链表是否有环
        ListNode fast = head;
        ListNode slow = head;
        Boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 两指针相遇，此时slow走了k步，fast走了2k步，且k就是环长度
                hasCycle = true;
                // 慢指针指向头结点
                slow = head;
                break;
            }
        }
        if (hasCycle) {
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
