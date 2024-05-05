package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No685 {

    int[] father;

    public static void main(String[] args) {
        No685 no = new No685();
        no.findRedundantDirectedConnection(new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        });
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 先查看所有节点的入度，看有没有为2的
        int[] inDegrees = new int[edges.length + 1];
        for (int[] edge : edges) {
            inDegrees[edge[1]]++;
        }
        List<int[]> maybeDelete = new ArrayList<>();
        for (int[] edge : edges) {
            if (inDegrees[edge[1]] == 2) {
                maybeDelete.add(edge);
            }
        }
        if (maybeDelete.isEmpty()) {
            // 寻找成环的边
            return findCircleEdge(edges);
        }
        for (int i = maybeDelete.size() - 1; i >= 0; i--) {
            int[] edge = maybeDelete.get(i);
            if (isAValidTree(edge, edges)) {
                return edge;
            }
        }
        return null;
    }

    private boolean isAValidTree(int[] remove, int[][] edges) {
        init(edges);
        for (int[] edge : edges) {
            if (edge == remove) continue;
            if (find(edge[0]) == find(edge[1])) {
                return false;
            }
            join(edge[0], edge[1]);
        }
        return true;
    }

    private int[] findCircleEdge(int[][] edges) {
        init(edges);
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            join(edge[0], edge[1]);
        }
        return null;
    }

    private void init(int[][] edges) {
        father = new int[edges.length + 5];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    private int find(int i) {
        if (father[i] != i) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void join(int root, int sub) {
        int fi = find(root);
        int fj = find(sub);
        if (fi == fj) return;
        father[fj] = fi;
    }

}