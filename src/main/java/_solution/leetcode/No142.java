package _solution.leetcode;

class No142 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // 快慢指针，快指针一次2步，慢的一次1步
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 有环
                ListNode one = head;
                ListNode two = fast;
                // one two相遇的节点即是答案
                while (one != two) {
                    one = one.next;
                    two = two.next;
                }
                return one;
            }
        }
        return null;
    }
/*
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。

输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
 */
}