package _solution.leetcode;

import util.JacksonUtil;

import java.util.*;

class No2192 {

    public static void main(String[] args) {
        No2192 no = new No2192();
        List<List<Integer>> ancestors = no.getAncestors(6, new int[][]{
                {0, 3}, {5, 0}, {2, 3}, {4, 3}, {5, 3}, {1, 3}, {2, 5}, {0, 1}, {4, 5}, {4, 2}, {4, 0}, {2, 1}, {5, 1}
        });
        System.out.println(JacksonUtil.writeValueAsString(ancestors));
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 反向建图
        Map<Integer, List<Integer>> mapReverse = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = mapReverse.computeIfAbsent(edge[1], k -> new ArrayList<>());
            list.add(edge[0]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        // dfs构造答案
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (mapReverse.containsKey(i)) dfs(i, visited, mapReverse, res);
            }
        }
        return res;
    }

    private void dfs(int i, boolean[] visited, Map<Integer, List<Integer>> mapReverse, List<List<Integer>> res) {
        // 处理node i
        Set<Integer> parents = new HashSet<>();
        // 可以访问的node
        List<Integer> toNodes = mapReverse.getOrDefault(i, new ArrayList<>());
        for (Integer node : toNodes) {
            if (!visited[node]) {
                // 还没有访问过
                visited[node] = true;
                dfs(node, visited, mapReverse, res);
            }
            parents.addAll(res.get(node));
            parents.add(node);
        }
        List<Integer> sorted = new ArrayList<>(parents);
        Collections.sort(sorted);
        res.set(i, sorted);
    }

}
