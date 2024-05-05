package _solution.contest.biweekly.w129;

class No1 {

    public boolean canMakeSquare(char[][] grid) {
        if (hasAns(grid)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                reverse(grid, i, j);
                if (hasAns(grid)) {
                    return true;
                }
                reverse(grid, i, j);
            }
        }
        return false;
    }

    private void reverse(char[][] grid, int i, int j) {
        if (grid[i][j] == 'W') {
            grid[i][j] = 'B';
        } else {
            grid[i][j] = 'W';
        }
    }

    private boolean hasAns(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                char x = grid[i][j];
                if (x == grid[i + 1][j]
                        && x == grid[i][j + 1]
                        && x == grid[i + 1][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

}
