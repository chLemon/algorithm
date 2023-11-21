package leetcode;

public class No24 {

    public static void main(String[] args) {
        No24 no = new No24();
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        ListNode res = no.swapPairs(test1);
        no.print(res);
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode swapPairs(ListNode head) {
        ListNode virtual = new ListNode(0, head);
        ListNode cur = virtual;
        ListNode one, two, next; 
        while (cur.next != null && cur.next.next != null) {
            one = cur.next;
            two = cur.next.next;
            next = two.next;
            
            // swap
            cur.next = two;
            two.next = one;
            one.next = next;
            
            // move
            cur = one;
        }
        return virtual.next;
    }

    public static class ListNode {
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


