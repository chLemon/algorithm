package programmercarl;

class No24 {

    public static void main(String[] args) {
        No24 no = new No24();
        no.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        ListNode root = pre;

        ListNode one = head;
        ListNode two = one == null ? null : one.next;
        while (one != null && two != null) {
            ListNode next = two.next;

            pre.next = two;
            two.next = one;
            one.next = next;

            pre = one;
            one = next;
            two = one == null ? null : next.next;
        }
        return root.next;
    }

}
