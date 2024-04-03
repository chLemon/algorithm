package leetcode;

public class No684 {

    int[] father;

    public int[] findRedundantConnection(int[][] edges) {
        father = new int[edges.length + 5];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            join(edge[0], edge[1]);
        }
        return null;
    }

    private int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void join(int i, int j) {
        int fatherI = find(i);
        int fatherJ = find(j);
        if (fatherI == fatherJ) return;
        father[fatherI] = fatherJ;
    }

}
