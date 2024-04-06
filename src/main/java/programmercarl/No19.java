package programmercarl;

class No19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        ListNode pre = new ListNode(-1, head);
        ListNode root = pre;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        // 删除slow所在的节点
        pre.next = slow.next;
        return root.next;
    }
}
