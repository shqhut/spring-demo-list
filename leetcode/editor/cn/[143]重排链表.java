
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
    public void reorderList(ListNode head) {
        // 借助栈先进后出的特性
        Stack<ListNode> stack = new Stack<>();
        // 操作链表的指针
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        p = head;
        while (p.next != null) {
            // 链表尾节点
            ListNode lastNode = stack.pop();
            ListNode next = p.next;
            if (lastNode == next || lastNode.next == next) {
                lastNode.next = null;
                break;
            }
            p.next = lastNode;
            lastNode.next = next;
            p = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
