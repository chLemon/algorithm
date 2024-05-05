package _solution.sword_to_offer;

import domain.ListNode;

class No24 {
    /*

     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }

}
