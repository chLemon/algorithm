package _solution.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No30 {

    public static void main(String[] args) {
        new No30().findSubstring("l ingm indr aboo fooo wing ding barr wing monk eypoundcake",
                new String[]{"fooo", "barr", "wing", "ding", "wing"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> word2Count = new HashMap<>();
        for (String w : words) {
            word2Count.merge(w, 1, Integer::sum);
        }
        int w = words[0].length();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            // 每一个位置，按照滑动窗口计算
            Map<String, Integer> eachCount = new HashMap<>();
            int left = i;
            for (int right = i; right + w <= s.length(); right += w) {
                // in
                String in = s.substring(right, right + w);
                eachCount.merge(in, 1, Integer::sum);
                // out
                if ((right - left) / w + 1 > words.length) {
                    String out = s.substring(left, left + w);
                    eachCount.merge(out, -1, Integer::sum);
                    if (eachCount.get(out) == 0) eachCount.remove(out);
                    left += w;
                }
                if (eachCount.get(in) > word2Count.getOrDefault(in, 0)) continue;

                if (word2Count.equals(eachCount)) res.add(left);
            }
        }
        return res;
    }

}
