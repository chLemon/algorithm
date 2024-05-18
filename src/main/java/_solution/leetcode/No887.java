package _solution.leetcode;

public class No887 {
    /*
    1蛋问题：
    只能从1层开始挨着试。
    所以如果有T次机会，那么就能确定 T+1 层楼时的F。

    2蛋问题：
    假设有T次机会，
    如果第一个蛋破碎后，那么只能从下方继续确定楼层，d1(t - 1)
    如果第一个蛋没破碎，那么需要在上方继续探索，d2(t - 1)
    加上本层 d2 = d1(t - 1) + 1 + d2(t - 1)

    所以是 d(k,t) = d(k-1,t-1) + 1 + d(k, t-1)
    举个例子：
    第一次必须在 d2,3 。第一次必须在 d1,2 处扔。因为如果这时候碎了，我们可以继续向下，d1,2的机会足够我们找到F。
    如果没碎，那么就可以往上方找。
     */
    public static void main(String[] args) {
        int i = new No887().superEggDrop(2, 6);
        System.out.println(i);
    }

    public int superEggDrop(int K, int N) {
        int[][] d = new int[K + 1][N + 1];
        // init d[0][...] = 0
        // init d[...][0] = 0
        for (int t = 1; t < N + 1; t++) {
            for (int k = 1; k < K + 1; k++) {
                d[k][t] = d[k - 1][t - 1] + 1 + d[k][t - 1];
                if (d[k][t] >= N) {
                    return t;
                }
            }
        }
        return N;
    }

}
