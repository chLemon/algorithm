package _solution.leetcode;

import domain.ListNode;

class No92 {

    public static void main(String[] args) {
        new No92().reverseBetween(
                new ListNode(5),
                1, 1
        );
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode cur = p0.next;
        ListNode pre = null;
        // 翻转
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        // pre是翻转部分新的head
        // cur是下一个节点
        // p0是翻转部分的前一个节点
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

}
