package _solution.programmercarl;

import java.util.*;

class No496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num2Index = new HashMap<>();
        int[] nums2Next = new int[nums2.length];
        Arrays.fill(nums2Next, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                Integer last = stack.pop();
                nums2Next[last] = nums2[i];
            }
            stack.push(i);
            num2Index.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nums2Next[num2Index.get(nums1[i])];
        }
        return res;

    }

}
