package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> num2Frequency = new HashMap<>();
        for (int num : arr) {
            Integer frequency = num2Frequency.getOrDefault(num, 0);
            num2Frequency.put(num, frequency + 1);
        }
        Set<Integer> frequencySet = new HashSet<>(num2Frequency.values());
        return num2Frequency.values().size() == frequencySet.size();
    }
    
}
