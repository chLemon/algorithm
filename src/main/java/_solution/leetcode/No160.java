package _solution.leetcode;

class No160 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 获取两个list的长度
        int aLength = 1;
        int bLength = 1;
        ListNode moveA = headA;
        ListNode moveB = headB;
        while (moveA.next != null) {
            moveA = moveA.next;
            aLength++;
        }
        while (moveB.next != null) {
            moveB = moveB.next;
            bLength++;
        }

        // 尾端对齐
        int min = Math.min(aLength, bLength);
        // [1,2,3,4,5] 如果另一个为3，那么需要走2步
        moveA = headA;
        moveB = headB;
        for (int i = 0; i < aLength - min; i++) {
            moveA = moveA.next;
        }
        for (int i = 0; i < bLength - min; i++) {
            moveB = moveB.next;
        }
        // 对齐后，一起移动并判等
        while (moveA != null && moveB != null) {
            if (moveA == moveB) {
                return moveA;
            }
            moveA = moveA.next;
            moveB = moveB.next;
        }
        return null;
    }
}
