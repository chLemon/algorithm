package endlesscheng;

public class No2730 {

    public int longestSemiRepetitiveSubstring(String s) {
        int maxLen = 1;
        int left = -1;
        int lastRepeat = -1;
        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                if (lastRepeat != -1) {
                    left = lastRepeat;
                }
                lastRepeat = right - 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

}
