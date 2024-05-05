package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No797 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        backTracing(0, graph, path);
        return res;
    }

    private void backTracing(int cur, int[][] graph, List<Integer> path) {
        path.add(cur);
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            int[] reachable = graph[cur];
            for (int next : reachable) {
                backTracing(next, graph, path);
            }
        }

        path.remove(path.size() - 1);
    }

}
