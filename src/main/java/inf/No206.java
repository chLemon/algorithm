package inf;

public class No206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}
