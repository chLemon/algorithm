package _solution.leetcode;

import domain.ListNode;

class No2816 {

    public static void main(String[] args) {
        new No2816().doubleIt(new ListNode(1, new ListNode(8, new ListNode(9))));
    }

    public ListNode doubleIt(ListNode head) {
        ListNode reverse = reverse(head);
        ListNode newHead = doubleIt2(reverse);
        return reverse(newHead);
    }

    private ListNode doubleIt2(ListNode head) {
        int carry = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (head != null || carry != 0) {
            if (head != null) carry += head.val * 2;
            pre.next = new ListNode(carry % 10);
            carry /= 10;

            pre = pre.next;
            if (head != null) head = head.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = pre;

            pre = head;
            head = nxt;
        }
        return pre;
    }

}
