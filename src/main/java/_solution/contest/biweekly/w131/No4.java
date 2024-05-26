package _solution.contest.biweekly.w131;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No4 {
    public static void main(String[] args) {
        No4 no = new No4();
        System.out.println(no.getResults(new int[][]{
                {1, 2},
                {2, 3, 3},
                {2, 3, 1},
                {2, 2, 2}
        }));
    }

    boolean[] hasBlock;

    public List<Boolean> getResults(int[][] queries) {
        int max = 0;
        for (int i = 0; i < queries.length; i++) {
            max = Math.max(max, queries[i][1]);
        }
        max = max + 1;
        hasBlock = new boolean[4 * max];

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                add(0, query[1], query[1]);
            } else {
                int x = query[1];
                int sz = query[2];
                boolean tRes = false;
                for (int i = 0, j = sz; j <= x; i++, j++) {
                    boolean t = query(0, 0, max, i, j);
                    if (t) {
                        tRes = true;
                        break;
                    }
                }
                res.add(tRes);
            }
        }
        return res;
    }

    private void add(int index, int l, int r) {
        if (l == r) {
            hasBlock[index] = true;
            return;
        }
        int mid = l + r >>> 1;
        if (index <= mid) {
            add(index * 2, l, mid);
        } else {
            add(index * 2 + 1, mid + 1, r);
        }
        hasBlock[index] = hasBlock[index * 2] || hasBlock[index * 2 + 1];
    }

    private boolean query(int index, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return hasBlock[index];
        }
        boolean res = false;
        int mid = l + r >>> 1;
        if (index <= mid) {
            res = query(index * 2, l, mid, L, R);
        }
        if (R > mid) {
            res = res || query(index * 2 + 1, mid + 1, r, L, R);
        }
        return res;
    }

}
