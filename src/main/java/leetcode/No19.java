package leetcode;

class No19 {

    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 有可能删除掉第一个节点，所以弄一个 dummy
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        // 先走n步
        // 0 [1, 2, 3] 删除倒数第3个，当第一个指针为空时，指针应该在0的位置，所以第一个指针先走3步
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        ListNode pre = dummy;
        // 然后一起往后走，直到cur == null
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        // 删除掉pre后面的Node
        pre.next = pre.next.next;
        return dummy.next;
    }

    /*
    输入：head = [1,2,3,4,5], n = 2
    输出：[1,2,3,5]
    示例 2：
    
    输入：head = [1], n = 1
    输出：[]
    示例 3：
    
    输入：head = [1,2], n = 1
    输出：[1]

     */
    private class ListNode {
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
