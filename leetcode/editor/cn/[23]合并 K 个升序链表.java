
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        // 操作链表的指针
        ListNode p = dummy;

        // 借助PriorityQueue获取最小头节点
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((x,y) -> x.val-y.val);
        for (ListNode head : lists){
            if (head != null) {
                priorityQueue.add(head);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            p = p.next;
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
