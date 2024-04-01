package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No407 {

    public int trapRainWater(int[][] heightMap) {
        // water[i][j]=max(heightMap[i][j],min(water[i−1][j],water[i+1][j],water[i][j−1],water[i][j+1]))

        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        // 根据高度的小顶堆，0是id
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        // 四个边加入进去
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i * n + j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int k = 0; k < 4; k++) {
                // 四个方向
                int nx = cur[0] / n + dirs[k];
                int ny = cur[0] % n + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // 合法且未访问
                    if (cur[1] > heightMap[nx][ny]) {
                        // 如果水位比高度高，可以加水
                        res += cur[1] - heightMap[nx][ny];
                    }
                    // 更新这个点的水位高度
                    pq.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], cur[1])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }

}
