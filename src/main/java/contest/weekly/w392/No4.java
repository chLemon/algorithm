package contest.weekly.w392;

class No4 {

    int[] pa;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // 与 越与越小，在一个联通块里，则全部参与就是最小值
        pa = new int[n + 5];

        for (int[] edge : edges) {
            join(edge[0], edge[1]);
        }

        // 图全部联通后
        // todo 不会做，等明天的题解
        

        
        
        return null;
    }

    private void init() {
        for (int i = 0; i < pa.length; i++) {
            pa[i] = i;
        }
    }

    private int find(int i) {
        if (pa[i] != i) {
            pa[i] = pa[find(i)];
        }
        return pa[i];
    }

    private void join(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) return;
        pa[pi] = pj;
    }

}
