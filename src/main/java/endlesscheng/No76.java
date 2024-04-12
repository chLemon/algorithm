package endlesscheng;

public class No76 {

    public static void main(String[] args) {
        No76 no = new No76();
        no.minWindow("a", "aa");
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] tCount = new int['z' + 1];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        int[] sCount = new int['z' + 1];
        char[] sChars = s.toCharArray();
        int resLeft = -1;
        int resRight = 0x3f3f3f3;
        int left = 0;
        for (int right = 0; right < sChars.length; right++) {
            sCount[sChars[right]]++;
            while (cover(sCount, tCount)) {
                if (resRight - resLeft > right - left + 1) {
                    resRight = right + 1;
                    resLeft = left;
                }
                sCount[sChars[left++]]--;
            }
        }
        return resLeft < 0 ? "" : s.substring(resLeft, resRight);
    }

    private boolean cover(int[] sCount, int[] tCount) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (tCount[i] > sCount[i]) {
                return false;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if (tCount[i] > sCount[i]) {
                return false;
            }
        }
        return true;
    }

}
