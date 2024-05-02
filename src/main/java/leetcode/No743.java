package leetcode;

import java.util.*;

class No743 {


    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 0x3f3f3f;
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }
        for (int[] t : times) {
            graph[t[0] - 1][t[1] - 1] = t[2];
        }

        int maxDis = 0;
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[k - 1] = 0;
        boolean[] done = new boolean[n];    // S集合

        while (true) {
            int x = -1;
            // 找到未确定里的最小的
            for (int i = 0; i < n; i++) {
                if (!done[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;// 找到dis里最小的
                }
            }
            if (x < 0) {
                return maxDis;  // 都访问过了
            }
            if (dis[x] == INF) {
                return -1; // 有节点不能访问
            }
            maxDis = dis[x];    // 更新答案
            done[x] = true; // x已经是最短的了，确定答案
            for (int y = 0; y < n; y++) {
                // 更新x的邻居
                dis[y] = Math.min(dis[y], dis[x] + graph[x][y]);
            }
        }
        // 复杂度 O(n^2)
        // 每个节点都会成为一次done，每次done都要找最小值，更新邻居
    }

    // 堆
    public int networkDelayTime2(int[][] times, int n, int k) {
        int INF = 0x3f3f3f;
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] t : times) {
            graph[t[0] - 1].add(new int[]{t[1] - 1, t[2]});
        }

        int maxDis = 0;
        int left = n;   // 未确定的节点数
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[k - 1] = 0;
        // 堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k - 1});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int dx = p[0];
            int x = p[1];
            // 如果弹出来的是一个之前推进去的，比dis还大
            if (dx > dis[x]) { // 之前访问过
                continue;
            }
            maxDis = dx; // 求出的最短路会越来越大
            left--; // 当前节点已确定

            for (int[] e : graph[x]) {
                // 更新x的邻居
                int y = e[0];
                int newDis = dx + e[1];
                if (newDis < dis[y]) {
                    dis[y] = newDis; // 更新 x 的邻居的最短路
                    pq.offer(new int[]{newDis, y});
                }
            }
        }

        return left == 0 ? maxDis : -1;
    }


}
