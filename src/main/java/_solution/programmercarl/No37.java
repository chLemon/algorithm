package _solution.programmercarl;

class No37 {

    char[][] board;
    boolean[][] lineSets = new boolean[9][9];
    boolean[][] columnSets = new boolean[9][9];
    boolean[][] blockSets = new boolean[9][9];

    public static void main(String[] args) {
        No37 no = new No37();
        no.solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        init();
        dfs(0);
    }

    private boolean dfs(int num) {
        if (num == 81) {
            return true;
        }
        int i = num / 9;
        int j = num % 9;

        if (board[i][j] == '.') {
            for (int k = 0; k < 9; k++) {
                // 尝试填写
                if (lineSets[i][k] || columnSets[j][k] || blockSets[getBlockIndex(i, j)][k]) {
                    continue;
                }
                board[i][j] = (char) (k + '1');
                lineSets[i][k] = true;
                columnSets[j][k] = true;
                blockSets[getBlockIndex(i, j)][k] = true;

                if (dfs(num + 1)) return true;

                board[i][j] = '.';
                lineSets[i][k] = false;
                columnSets[j][k] = false;
                blockSets[getBlockIndex(i, j)][k] = false;
            }
        } else {
            return dfs(num + 1);
        }
        return false;
    }

    private void init() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = c - '1';
                    lineSets[i][n] = true;
                    columnSets[j][n] = true;
                    blockSets[getBlockIndex(i, j)][n] = true;
                }
            }
        }
    }

    private int getBlockIndex(int i, int j) {
        return (i / 3) + (j / 3) * 3;
    }

}
