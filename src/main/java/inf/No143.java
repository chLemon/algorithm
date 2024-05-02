package inf;

class No143 {

    public static void main(String[] args) {
        new No143().reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // find middle
        ListNode mid = slow;

        // reverse middle
        ListNode cur = mid;
        ListNode pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }

        ListNode head2 = pre;
        while (head2.next != null) {
            ListNode headNext = head.next;
            ListNode head2Next = head2.next;

            head.next = head2;
            head2.next = headNext;

            head = headNext;
            head2 = head2Next;
        }
    }

}
