package leetcode;

class No2924 {

    public int findChampion(int n, int[][] edges) {
        // 寻找入度为0的节点
        int[] indegrees = new int[n];
        for (int[] edge : edges) {
            indegrees[edge[1]]++;
        }
        int champion = -1;
        for (int i = 0; i < indegrees.length; i++) {
            int indegree = indegrees[i];
            if (indegree == 0) {
                if (champion == -1) {
                    champion = i;
                } else {
                    return -1;
                }
            }
        }
        return champion;
    }

}
