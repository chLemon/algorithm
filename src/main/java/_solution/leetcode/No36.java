package _solution.leetcode;

public class No36 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] lines = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] sets = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            // line
            for (int j = 0; j < 9; j++) {
                // col
                if (board[i][j] == '.') continue;
                int n = board[i][j] - '1';
                int setIndex = i / 3 * 3 + j / 3;

                if (lines[i][n] || columns[j][n] || sets[setIndex][n]) return false;
                lines[i][n] = columns[j][n] = sets[setIndex][n] = true;
            }
        }
        return true;
    }
}
