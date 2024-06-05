package template;

public class UnionFind {

    int[] arr;

    // 并查集，使用模板
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        init(n);
        for (int[] edge : edges) {
            join(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }

    private void join(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) return;
        arr[pi] = pj;
    }

    private int find(int i) {
        if (arr[i] != i) {
            arr[i] = find(arr[i]);
        }
        return arr[i];
    }

    private void init(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }
}
