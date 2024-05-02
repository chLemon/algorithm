package inf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No52 {
    int res = 0;
    int[] positions;
    boolean[] columnHas;
    boolean[] leftCross;
    boolean[] rightCross;
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        positions = new int[n];

        columnHas = new boolean[n];
        leftCross = new boolean[2 * n - 1];
        rightCross = new boolean[2 * n - 1];

        dfs(0);

        return res;
    }

    private void dfs(int row) {
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (columnHas[col] || leftCross[row - col + n - 1] || rightCross[row + col]) continue;
            positions[row] = col;
            columnHas[col] = leftCross[row - col + n - 1] = rightCross[row + col] = true;
            dfs(row + 1);

            columnHas[col] = leftCross[row - col + n - 1] = rightCross[row + col] = false;
        }
    }

    private List<String> getChess() {
        List<String> chess = new ArrayList<>();
        char[] line = new char[n];
        Arrays.fill(line, '.');
        for (int position : positions) {
            line[position] = 'Q';
            chess.add(new String(line));
            line[position] = '.';
        }
        return chess;
    }


}
