package _solution.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class No1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> num2Frequency = new HashMap<>();
        for (int num : arr) {
            Integer frequency = num2Frequency.getOrDefault(num, 0);
            num2Frequency.put(num, frequency + 1);
        }
        // 这里手动遍历values维护set应该可以节约一点点的复杂度，但是没啥必要吧
        Set<Integer> frequencySet = new HashSet<>(num2Frequency.values());
        return num2Frequency.values().size() == frequencySet.size();
    }

}
