package leetcode;

public class No130 {

    public void solve(char[][] board) {
        // 访问边界，所有O改为A
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') dfs(i, j, board);
                }
            }
        }

        // 遍历全部，所有O改为X，A改为O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        board[i][j] = 'A';

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];

            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && board[ni][nj] == 'O') {
                dfs(ni, nj, board);
            }
        }
    }

}
