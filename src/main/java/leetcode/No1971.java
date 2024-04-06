package leetcode;

class No1971 {

    int[] arr;

    public static void main(String[] args) {
        No1971 no = new No1971();
        boolean b = no.validPath(10, new int[][]{
                {0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}
        }, 7, 5);
        System.out.println(b);
    }

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
