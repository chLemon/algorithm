package _solution.leetcode;

import _solution.inf.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

class No1019 {

    public int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int[] res = new int[n];
        int i = 0;
        cur = head;
        Deque<int[]> stack = new ArrayDeque<>();
        while (cur != null) {
            while (!stack.isEmpty() && cur.val > stack.peek()[1]) {
                int[] pop = stack.pop();
                res[pop[0]] = cur.val;
            }
            stack.push(new int[]{i++, cur.val});
            cur = cur.next;
        }
        return res;
    }

}
