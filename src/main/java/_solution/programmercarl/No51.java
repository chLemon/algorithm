package _solution.programmercarl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No51 {

    List<int[]> res = new ArrayList<>();
    int[] queens;
    int n;

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        Arrays.fill(queens, -1);
        this.n = n;
        dfs(0);
        return toChessString(res);
    }

    private List<List<String>> toChessString(List<int[]> res) {
        List<List<String>> resStr = new ArrayList<>();
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int[] each : res) {
            List<String> chess = new ArrayList<>();
            for (int queen : each) {
                chars[queen] = 'Q';
                chess.add(new String(chars));
                chars[queen] = '.';
            }
            resStr.add(chess);
        }
        return resStr;
    }

    private void dfs(int lineNum) {
        if (lineNum == n) {
            // 也可以这里直接转换成chessStr加到res里
            res.add(Arrays.copyOf(queens, queens.length));
            return;
        }
        // 放置第lineNum行
        boolean[] block = new boolean[n];
        cal(lineNum, block);
        for (int i = 0; i < block.length; i++) {
            if (!block[i]) {
                // 这个位置可以尝试
                queens[lineNum] = i;
                dfs(lineNum + 1);
                queens[lineNum] = -1;
            }
        }
    }

    private void cal(int lineNum, boolean[] block) {
        // 根据queens的情况，判断lineNum里哪些格子可以放
        for (int i = 0; i < lineNum; i++) {
            int j = queens[i];
            block[j] = true;
            // 斜着的2个位置
            int diff = lineNum - i;
            if (j + diff < block.length) {
                block[j + diff] = true;
            }
            if (j - diff >= 0) {
                block[j - diff] = true;
            }
        }
    }

}
