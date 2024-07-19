package _solution.leetcode;

import java.util.HashSet;
import java.util.Set;

class No128 {

    /*
    summary:
    中等
    hot100

    思路:
    将所有数维护在一个set中，遍历查找是否有 x + 1 （或者x - 1）
    如果有，说明这个数不是答案子序列的末尾置（起始值），跳过
    没有，则是，计数这个子序列有多长

    复杂度:
    时间 O(n)
    空间 O(n)
     */

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int max = 0;
        for (int i : nums) {
            if (set.contains(i - 1)) continue;
            int j = 1;
            while (set.contains(i + j)) {
                j++;
            }
            max = Math.max(max, j);
        }
        return max;
    }

}
