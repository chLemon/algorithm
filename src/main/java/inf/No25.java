package inf;

class No25 {

    public static void main(String[] args) {
        new No25().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int valid = count / k * k;

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        while (valid > 0) {
            ListNode pre = null;
            cur = p0.next;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;

                pre = cur;
                cur = next;
            }
            ListNode p1 = p0.next;
            p1.next = cur;
            p0.next = pre;
            valid -= k;
            p0 = p1;
        }
        return dummy.next;
    }

}
