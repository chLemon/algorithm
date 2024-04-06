package programmercarl;

class No203 {

    public static void main(String[] args) {
        No203 no = new No203();
        no.removeElements(new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1, head);
        ListNode pre = root;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = head.next;
            } else {
                pre = pre.next;
                head = head.next;
            }
        }
        return root.next;
    }

}
