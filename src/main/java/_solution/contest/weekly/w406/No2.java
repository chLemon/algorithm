package _solution.contest.weekly.w406;

import domain.ListNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class No2 {

    public static void main(String[] args) {

    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
