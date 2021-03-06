package codinginterviews;

import codinginterviews.domain.ListNode;

public class No24 {
    /*

     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (next!=null){
            curr.next=pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }

}
