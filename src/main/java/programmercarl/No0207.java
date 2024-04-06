package programmercarl;

class No0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        int countA = 0;
        while (a != null) {
            a = a.next;
            countA++;
        }

        ListNode b = headB;
        int countB = 0;
        while (b != null) {
            b = b.next;
            countB++;
        }

        a = headA;
        b = headB;
        if (countB > countA) {
            // b先走
            for (int i = 0; i < countB - countA; i++) {
                b = b.next;
            }
        } else {
            for (int i = 0; i < countA - countB; i++) {
                a = a.next;
            }
        }

        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }

}
