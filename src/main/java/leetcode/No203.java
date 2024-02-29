package leetcode;

public class No203 {

    static class ListNode {
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
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode virtualHead = new ListNode(0, head);
        // 遍历，移除val相等的节点
        ListNode node = virtualHead;
        while (node != null && node.next != null) {
            while (node.next != null && node.next.val == val) {
                // 删除该节点
                node.next = node.next.next;
            }
            // 移动到下一个节点
            node = node.next;
        }
        return virtualHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}