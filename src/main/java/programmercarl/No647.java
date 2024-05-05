package programmercarl;

class No647 {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    f[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        f[i][j] = true;
                    } else {
                        f[i][j] = f[i + 1][j - 1];
                    }
                }
                if (f[i][j]) count++;
            }
        }
        return count;
    }

}
