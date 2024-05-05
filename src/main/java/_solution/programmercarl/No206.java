package _solution.programmercarl;

class No206 {

    public ListNode reverseList(ListNode head) {
        ListNode one = null;
        ListNode two = head;
        while (two != null) {
            ListNode next = two.next;
            two.next = one;
            one = two;
            two = next;
        }
        return one;
    }

}
