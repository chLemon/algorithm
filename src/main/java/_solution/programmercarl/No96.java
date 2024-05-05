package _solution.programmercarl;

class No96 {

    public static void main(String[] args) {
        new No96().numTrees(3);
    }

    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 左子树节点数从0到n-1 右子树节点从 n-1 到 0
            for (int j = 0; j < i; j++) {
                f[i] += (f[j] * f[i - j - 1]);
            }
        }
        return f[n];
    }

}
