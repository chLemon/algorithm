package _solution.contest.weekly.w396;

import java.util.HashMap;
import java.util.Map;

class No2 {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> count = new HashMap<>();
        int i = 0;
        int max = 0;
        while (i < word.length()) {
            String loop = word.substring(i, i + k);
            Integer c = count.getOrDefault(loop, 0);
            count.put(loop, c + 1);
            max = Math.max(max, c + 1);
            i += k;
        }

        return (word.length() / k) - max;
    }

}
