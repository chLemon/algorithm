package inf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2246 {

    int max = 0;
    String s;

    public static void main(String[] args) {
        new No2246().longestPath(new int[]{-1, 0, 1}, "aab");
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, k -> new ArrayList<Integer>());
        for (int i = 1; i < parent.length; i++) {
            graph[parent[i]].add(i);
        }

        dfs(graph, 0);

        return max + 1;
    }

    private int dfs(List<Integer>[] graph, int root) {
        int res = -1;
        List<Integer> children = graph[root];
        for (Integer child : children) {
            int childLength = dfs(graph, child);
            if (s.charAt(root) != s.charAt(child)) {
                // res是之前最大的
                max = Math.max(max, res + childLength + 2);
                res = Math.max(childLength, res);
            }
        }
        return res + 1;
    }

}
