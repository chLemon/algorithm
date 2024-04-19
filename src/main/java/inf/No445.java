package inf;

public class No445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 翻转l1 l2 相加，结果翻转
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int carry = 0;
        while (r1 != null || r2 != null || carry != 0) {
            if (r1 != null) carry += r1.val;
            if (r2 != null) carry += r2.val;
            pre.next = new ListNode(carry % 10);
            pre = pre.next;
            carry /= 10;
            if (r1 != null) r1 = r1.next;
            if (r2 != null) r2 = r2.next;
        }
        return reverse(dummy.next);
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
