package _solution.sword_to_offer;

import java.util.LinkedList;
import java.util.Queue;

class No13 {

    /*
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
    一个机器人从坐标 [0, 0] 的格子开始移动，
    它每次可以向左、右、上、下移动一格（不能移动到方格外），
    也不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格 [35, 37] ，
    因为3+5+3+7=18。但它不能进入方格 [35, 38]，
    因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */

//    public int movingCount(int m, int n, int k) {
////    提示：     1 <= n,m <= 100        0 <= k <= 20
//        boolean[][] mem = new boolean[m][n];
//
//        return dfs(0, 0, k, mem, m, n);
//    }

    public int dfs(int i, int j, int k, boolean[][] mem, int m, int n) {
        //如果越界，非法，或已访问，则返回
        if (i < 0 || i >= m || j < 0 || j >= n || mem[i][j] || i % 10 + i / 10 % 10 + i / 100 + j % 10 + j / 10 % 10 + j / 100 > k)
            return 0;
        //如果没有，该点遍历，并看邻居
        mem[i][j] = true;
        return 1 + dfs(i + 1, j, k, mem, m, n) + dfs(i - 1, j, k, mem, m, n) + dfs(i, j + 1, k, mem, m, n) + dfs(i, j - 1, k, mem, m, n);
    }

    public int movingCount(int m, int n, int k) {
//    提示：     1 <= n,m <= 100        0 <= k <= 20

        boolean[][] mem = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<int[]>();
//        queue.offer();
//        queue.poll();
//        queue.peek();
        int count = 0;
        queue.offer(new int[]{0, 0});
        count++;
        mem[0][0] = true;
        int[] p = null;

        while ((p = queue.poll()) != null) {
            int i = p[0] + 1;
            int j = p[1];
            if (!(i < 0 || i >= m || j < 0 || j >= n || mem[i][j]
                    || i % 10 + i / 10 % 10 + i / 100 + j % 10 + j / 10 % 10 + j / 100 > k)) {
                queue.offer(new int[]{i, j});
                count++;
                mem[i][j] = true;
            }
            i = p[0] - 1;
            if (!(i < 0 || i >= m || j < 0 || j >= n || mem[i][j]
                    || i % 10 + i / 10 % 10 + i / 100 + j % 10 + j / 10 % 10 + j / 100 > k)) {
                queue.offer(new int[]{i, j});
                count++;
                mem[i][j] = true;
            }
            i = p[0];
            j = p[1] + 1;
            if (!(i < 0 || i >= m || j < 0 || j >= n || mem[i][j]
                    || i % 10 + i / 10 % 10 + i / 100 + j % 10 + j / 10 % 10 + j / 100 > k)) {
                queue.offer(new int[]{i, j});
                count++;
                mem[i][j] = true;
            }
            j = p[1] - 1;
            if (!(i < 0 || i >= m || j < 0 || j >= n || mem[i][j]
                    || i % 10 + i / 10 % 10 + i / 100 + j % 10 + j / 10 % 10 + j / 100 > k)) {
                queue.offer(new int[]{i, j});
                count++;
                mem[i][j] = true;
            }
        }
        return count;
    }

    public void test() {
        /*
            示例 1：

    输入：m = 2, n = 3, k = 1
    输出：3
    示例 2：

    输入：m = 3, n = 1, k = 0
    输出：1

    提示：
            1 <= n,m <= 100
            0 <= k <= 20
         */
        System.out.println(movingCount(3, 2, 17));
    }
}
