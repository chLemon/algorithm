package _solution.contest.biweekly.w128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class No3 {

    public static void main(String[] args) {
        No3 no = new No3();
        no.minimumTime(7, new int[][]{
                {1, 4, 3}, {3, 4, 2}, {2, 5, 5}, {3, 3, 10}
        }, new int[]{10, 1, 13, 1, 7, 1, 19});
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, Map<Integer, Integer>> node2nodeCost = new HashMap<>();
        for (int[] edge : edges) {
            // 正向
            Map<Integer, Integer> toNodesCost = node2nodeCost.computeIfAbsent(edge[0], k -> new HashMap<>());
            toNodesCost.merge(edge[1], edge[2], Math::min);
            // 反向
            Map<Integer, Integer> reverse = node2nodeCost.computeIfAbsent(edge[1], k -> new HashMap<>());
            reverse.merge(edge[0], edge[2], Math::min);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;

        bfs(ans, node2nodeCost, disappear, 0);

        return ans;
    }

    private void bfs(int[] ans, Map<Integer, Map<Integer, Integer>> node2node, int[] disappear, int node) {
        // 已访问 node，开始访问node可以通向的地方
        Map<Integer, Integer> toNodesAndCosts = node2node.getOrDefault(node, new HashMap<>());

        // 目前已经花费的时间
        int pre = ans[node];
        // 访问每一个节点
        for (Map.Entry<Integer, Integer> entry : toNodesAndCosts.entrySet()) {
            int nextNode = entry.getKey();
            if (nextNode == node) continue;
            // 花费
            int nextValue = pre + entry.getValue();
            if (nextValue >= disappear[nextNode]) {
                // 到了也没了，此路不通
            } else {
                // 可以尝试
                if (ans[nextNode] == -1 || ans[nextNode] > nextValue) {
                    // 没访问过，或者更快访问，访问
                    ans[nextNode] = nextValue;
                    bfs(ans, node2node, disappear, nextNode);
                }
            }
        }
    }

}
