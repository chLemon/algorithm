package contest.weekly.w394;

import java.util.*;

class No4 {

    public static void main(String[] args) {
        boolean[] res = new No4().findAnswer(4, new int[][]
                {{2, 0, 1}, {0, 1, 1}, {0, 3, 4}, {3, 2, 2}}
        );
        System.out.println(Arrays.toString(res));
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        int[] nodeInfo = new int[n];
        Arrays.fill(nodeInfo, -1);
        Map<Integer, List<int[]>> node2nodeAndCost = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            node2nodeAndCost.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(new int[]{edge[1], edge[2], i});
            node2nodeAndCost.computeIfAbsent(edge[1], k -> new ArrayList<>())
                    .add(new int[]{edge[0], edge[2], i});
        }

        Set<Integer> pPoints = new HashSet<>();
        PriorityQueue<int[]> tPoints = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // 访问节点0
        pPoints.add(0);
        nodeInfo[0] = 0;
        List<int[]> nodeAndCost = node2nodeAndCost.getOrDefault(0, new ArrayList<>());
        for (int[] pair : nodeAndCost) {
            tPoints.add(new int[]{pair[0], pair[1]});
        }
        // 开始不断访问T节点
        while (!tPoints.isEmpty()) {
            // 取出最小的节点
            int[] minNode = tPoints.poll();

            if (minNode[0] == n - 1) {
                // 结束
                pPoints.add(n - 1);
                nodeInfo[n - 1] = minNode[1];
                break;
            }


            // 由于优先级队列会保存一些冗余数据，跳过
            int minNodeValue = minNode[0];
            if (pPoints.contains(minNodeValue)) {
                continue;
            }
            // 变为p
            pPoints.add(minNodeValue);
            nodeInfo[minNodeValue] = minNode[1];
            // 修改p周围的t
            List<int[]> neighbor = node2nodeAndCost.getOrDefault(minNodeValue, new ArrayList<>());
            for (int[] nei : neighbor) {
                if (pPoints.contains(nei[0])) {
                    continue;
                }
                // 修改值，加入t
                tPoints.offer(new int[]{nei[0], nei[1] + minNode[1]});
            }
        }

        // 从n-1 开始
        boolean[] res = new boolean[edges.length];
        if (nodeInfo[n - 1] < 0) return res;
        Queue<Integer> neigh = new LinkedList<>();
        neigh.offer(n - 1);
        while (!neigh.isEmpty()) {
            Integer node = neigh.poll();
            // 是从哪里走到这个节点的
            List<int[]> froms = node2nodeAndCost.getOrDefault(node, new ArrayList<>());
            for (int[] from : froms) {
                if (pPoints.contains(from[0])) {
                    int fromValue = nodeInfo[from[0]];
                    int cost = from[1];
                    if (fromValue + cost == nodeInfo[node]) {
                        // 可以从这里走来
                        res[from[2]] = true;
                        // 接下来访问这里
                        neigh.offer(from[0]);
                    }
                }
            }
        }
        return res;
    }

}
