package _solution.contest.biweekly.w128;

import java.util.*;

class No4 {

    public static void main(String[] args) {
        No4 no = new No4();
        System.out.println(no.numberOfSubarrays(new int[]{1, 38, 1, 28, 75}));

        System.out.println(no.numberOfSubarrays(new int[]{1, 4, 3, 3, 2}));

    }

    public long numberOfSubarrays(int[] nums) {
        // 维护每个值右侧最近的严格大于自己的数的下标
        int[] nextMaxes = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums.length - 1);
        nextMaxes[nums.length - 1] = nums.length;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[stack.peek()] <= nums[i]) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }
            }
            nextMaxes[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }

        // 维护每个值对应的下标
        Map<Integer, List<Integer>> num2Indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            num2Indexes.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // 处理结果
        long count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : num2Indexes.entrySet()) {
            List<Integer> indexes = entry.getValue();
            for (int i = 0; i < indexes.size(); i++) {
                // 从小的来看
                int nextMax = nextMaxes[indexes.get(i)];
                long n = 1;
                while (i + 1 < indexes.size() && indexes.get(i + 1) < nextMax) {
                    n++;
                    i++;
                }
                count += n * (n + 1) / 2;
            }
        }
        return count;
    }

}
