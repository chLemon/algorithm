package _solution.leetcode;

class No647 {

    public static void main(String[] args) {
        No647 no = new No647();
        no.countSubstrings("abc");
    }

    public int countSubstrings2(String s) {
        boolean[][] f = new boolean[s.length()][s.length()];
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (j - i == 0) {
                    f[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (j - i == 1) {
                        f[i][j] = b;
                    } else {
                        f[i][j] = b && f[i + 1][j - 1];
                    }
                }
                if (f[i][j]) count++;
            }
        }
        return count;
    }

    // 双指针中心点解法
    public int countSubstrings(String s) {
        int count = 0;
        int left, right;
        // 单元素中心点
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        // 双元素中心点
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
