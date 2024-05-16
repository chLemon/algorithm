package _solution.contest.weekly.w397;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class No3 {
    public static void main(String[] args) {
        System.out.println(new No3().maxScore(Arrays.asList(
                Arrays.asList(9, 5, 7, 3),
                Arrays.asList(8, 9, 6, 1),
                Arrays.asList(6, 7, 14, 3),
                Arrays.asList(2, 5, 3, 1)
        )));
    }

    int max = Integer.MIN_VALUE;

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] f = new int[m][n];

        PriorityQueue<Integer>[] downHeaps = new PriorityQueue[n];
        for (int i = 0; i < downHeaps.length; i++) {
            downHeaps[i] = new PriorityQueue<Integer>((a, b) -> -a.compareTo(b));
        }
        for (int i = m - 1; i >= 0; i--) {

            PriorityQueue<Integer> rightHeap = new PriorityQueue<>((a, b) -> -a.compareTo(b));
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    downHeaps[j].add(grid.get(i).get(j));
                    rightHeap.add(grid.get(i).get(j));
                    continue;
                }
                // rightHeap 可以获得的最大值
                Integer rightPeek = downHeaps[j].peek();
                int rightM = rightPeek == null ? Integer.MIN_VALUE
                        : rightPeek - grid.get(i).get(j);

                // down 可以获得的最大值
                Integer downPeek = rightHeap.peek();
                int downM = downPeek == null ? Integer.MIN_VALUE :
                        downPeek - grid.get(i).get(j);
                f[i][j] = Math.max(rightM, downM);

                downHeaps[j].offer(Math.max(f[i][j], 0) + grid.get(i).get(j));
                rightHeap.offer(Math.max(f[i][j], 0) + grid.get(i).get(j));

                max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }

}
