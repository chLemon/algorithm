package leetcode;

public class No24 {


    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head);
        swap(pre);
        return pre.next;
    }

    private void swap(ListNode pre) {
        ListNode head = pre.next;
        if (head == null) return;
        ListNode next = head.next;
        if (next == null) return;
        ListNode nextNext = next.next;
        // 交换head和next，将nextNext拼在后面
        pre.next = next;
        next.next = head;
        head.next = nextNext;
        swap(head);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
