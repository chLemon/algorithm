package _solution.leetcode;

import java.util.*;

class No1766 {

    int[] depths = new int[51]; // 表示节点值为 x 的节点，最近的深度是多少
    int[] indexes = new int[51]; // 表示值为x的节点，最近的编号是多少
    int[] nums;
    Map<Integer, List<Integer>> node2Nodes = new HashMap<>();
    private Map<Integer, List<Integer>> coprime = new HashMap<>();

    public int[] getCoprimes(int[] nums, int[][] edges) {
        this.nums = nums;
        // 预处理互质数字典
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    // i, j 互质
                    coprime.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        // 处理图
        for (int[] edge : edges) {
            // 由于不知道edge的0和1哪个是子节点，所以都需要加进去，遍历的时候通过0一定是父节点来处理
            node2Nodes.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            node2Nodes.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        // dfs处理
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        dfs(0, -1, 1, ans);

        return ans;
    }

    private void dfs(int i, int father, int depth, int[] ans) {
        int x = nums[i];

        // 与当前节点互质的所有值里，最深的节点
        int maxDepth = 0;
        for (Integer prime : coprime.get(x)) {
            // 与当前节点值互质的值
            int d = depths[prime];   // 该值对应的最近深度
            int in = indexes[prime];  // 对应的下标
            if (maxDepth < d) {
                maxDepth = d;
                ans[i] = in;
            }
        }

        // 更新
        int oldDepth = depths[x];
        int oldIndex = indexes[x];
        depths[x] = depth;
        indexes[x] = i;
        // 递归
        for (Integer node : node2Nodes.getOrDefault(i, new ArrayList<>())) {
            if (node != father) {
                // 子节点
                dfs(node, i, depth + 1, ans);
            }
        }

        // 回溯
        depths[x] = oldDepth;
        indexes[x] = oldIndex;
    }

    // 返回i j 的最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
