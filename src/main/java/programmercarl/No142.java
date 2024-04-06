package programmercarl;

class No142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode third = head;
                while (third != slow) {
                    third = third.next;
                    slow = slow.next;
                }
                return third;
            }
        }
        return null;
    }
}
