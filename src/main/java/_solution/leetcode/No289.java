package _solution.leetcode;

public class No289 {

    int[][] board;
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        this.board = board;
        // 定义 2 : 0 -> 1
        //      3 : 1 -> 0
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countLive(i, j);
                int old = board[i][j];
                if (old == 1) {
                    // 原来是活的
                    if (count < 2 || count > 3)
                        board[i][j] = 3;
                } else {
                    if (count == 3)
                        board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = board[i][j];
                if (x == 2) board[i][j] = 1;
                if (x == 3) board[i][j] = 0;
            }
        }
    }

    private int countLive(int i, int j) {
        int count = 0;
        for (int p = i - 1; p <= i + 1; p++) {
            if (p < 0 || p >= m) continue;
            for (int q = j - 1; q <= j + 1; q++) {
                if (q < 0 || q >= n) continue;

                if (p == i && q == j) continue;

                if (board[p][q] == 1 || board[p][q] == 3) count++;
            }
        }
        return count;
    }

}
