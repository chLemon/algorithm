package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No212 {

    List<String> res = new ArrayList<>();
    char[][] board;
    int m;
    int n;
    boolean[][] visited;
    TrieNode tt = new TrieNode();
    int[] dir = {-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        new No212().findWords(new char[][]{
                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"});
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) add(w);

        // 从每个点开始，dfs，12 * 12 * 10
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, tt);
            }
        }
        return res;
    }

    private void dfs(int i, int j, TrieNode cur) {
        int idx = board[i][j] - 'a';
        if (cur.tns[idx] == null) return;

        visited[i][j] = true;
        if (cur.tns[idx].s != null) {
            res.add(cur.tns[idx].s);
            cur.tns[idx].s = null;
        }

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k];
            int nj = j + dir[k + 1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) dfs(ni, nj, cur.tns[idx]);
        }
        visited[i][j] = false;
    }

    void add(String s) {
        TrieNode cur = tt;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.tns[idx] == null) cur.tns[idx] = new TrieNode();
            cur = cur.tns[idx];
        }
        cur.s = s;
    }

    class TrieNode {
        String s;
        TrieNode[] tns = new TrieNode[26];
    }

}
