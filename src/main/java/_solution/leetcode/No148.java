package _solution.leetcode;

import domain.ListNode;

public class No148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode sub = slow.next;
        slow.next = null;

        head = sortList(head);
        sub = sortList(sub);

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head != null && sub != null) {
            if (head.val < sub.val) {
                cur.next = head;
                head = head.next;
            } else {
                cur.next = sub;
                sub = sub.next;
            }
            cur = cur.next;
        }
        if (head != null) cur.next = head;
        if (sub != null) cur.next = sub;
        return dummy.next;
    }

}
