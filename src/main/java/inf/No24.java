package inf;

class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode one = pre.next;
        ListNode two = one == null ? null : one.next;
        while (one != null && two != null) {
            ListNode nxt = two.next;
            pre.next = two;
            two.next = one;
            one.next = nxt;

            pre = one;
            one = pre.next;
            two = one == null ? null : one.next;
        }
        return dummy.next;
    }

}
