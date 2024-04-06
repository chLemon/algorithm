package leetcode;

class No115 {

    public static void main(String[] args) {
        No115 no = new No115();
        int i = no.numDistinct("baegg", "bag");
        System.out.println(i);
    }

    public int numDistinct(String s, String t) {
        int[][] f = new int[s.length() + 1][t.length()];
        // 通过考虑s[i]选和不选，可以得出：
        // f[i][j] = 选s[i]，尾部字符串相等时f[i-1][j-1] + 不选s[i] f[i-1] [j]
        // 初始值考虑：模式串t为空，都是非法值。s为空，则表示没有能匹配成功的，为0。
        // 所以s0可以不处理，t0需要处理
        for (int i = 1; i <= s.length(); i++) {
            f[i][0] = t.charAt(0) == s.charAt(i - 1) ? f[i - 1][0] + 1 : f[i - 1][0];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                f[i][j] = f[i - 1][j] + (s.charAt(i - 1) == t.charAt(j) ? f[i - 1][j - 1] : 0);
            }
        }
        return f[s.length()][t.length() - 1];
    }

}
