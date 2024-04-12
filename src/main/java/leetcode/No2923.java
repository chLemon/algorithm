package leetcode;

class No2923 {

    // 此题还有其他2个解法，横着找规律和竖着找规律
    public int findChampion(int[][] grid) {
        // 打擂台
        int ans = 0;
        for (int i = 1; i < grid.length; i++) {
            if (grid[ans][i] == 0) {    // i 赢了，i 继续
                ans = i;
            }
        }
        return ans;
    }
}
