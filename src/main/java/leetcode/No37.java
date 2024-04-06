package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class No37 {

    List<Set<Character>> lineSets = new ArrayList<>(9);
    List<Set<Character>> columnSets = new ArrayList<>(9);
    List<Set<Character>> squareSets = new ArrayList<>(9);
    // lineNum, columnNum
    List<int[]> needToFill = new ArrayList<>();

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        No37 no = new No37();
        no.solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            lineSets.add(new HashSet<>());
            columnSets.add(new HashSet<>());
            squareSets.add(new HashSet<>());
        }

        // set初始化
        for (int i = 0; i < board.length; i++) {
            char[] boardLine = board[i];
            for (int j = 0; j < boardLine.length; j++) {
                char c = boardLine[j];
                if (c != '.') {
                    lineSets.get(i).add(c);
                    columnSets.get(j).add(c);
                    squareSets.get(getSquareIndex(i, j)).add(c);
                } else {
                    needToFill.add(new int[]{i, j});
                }
            }
        }

        backTracing(board, 0);

    }

    private boolean backTracing(char[][] board, int fillIndex) {
        if (fillIndex == needToFill.size()) {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            // 填充fillIndex的位置
            int[] lineNumColumnNum = needToFill.get(fillIndex);
            char fill = (char) ('1' + i);
            int lineNum = lineNumColumnNum[0];
            int columnNum = lineNumColumnNum[1];

            Set<Character> lineSet = lineSets.get(lineNum);
            if (lineSet.contains(fill)) {
                continue;
            }
            Set<Character> columnSet = columnSets.get(columnNum);
            if (columnSet.contains(fill)) {
                continue;
            }
            Set<Character> squareSet = squareSets.get(getSquareIndex(lineNum, columnNum));
            if (squareSet.contains(fill)) {
                continue;
            }

            // 可以填
            board[lineNum][columnNum] = fill;
            lineSet.add(fill);
            columnSet.add(fill);
            squareSet.add(fill);

            if (backTracing(board, fillIndex + 1)) return true;

            squareSet.remove(fill);
            columnSet.remove(fill);
            lineSet.remove(fill);
        }
        return false;
    }

    private int getSquareIndex(int lineNum, int columnNum) {
        return lineNum / 3 * 3 + columnNum / 3;
    }

}
