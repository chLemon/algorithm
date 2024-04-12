package endlesscheng;

import java.util.HashSet;
import java.util.Set;

class No3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            /*
            if (set.contains(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left++));
                }
                left++;
            } else {
                set.add(s.charAt(right));
            }
             */
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
