package _solution.programmercarl;

import java.util.*;

class No347 {

    public static void main(String[] args) {
        No347 no = new No347();
        int[] ints = no.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            Integer count = num2Count.getOrDefault(num, 0);
            num2Count.put(num, count + 1);
        }

        // 小顶堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(o -> o[0]));
        for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 你可以按 任意顺序 返回答案
        int[] res = new int[k];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = minHeap.poll()[1];
        }
        return res;
    }

}
