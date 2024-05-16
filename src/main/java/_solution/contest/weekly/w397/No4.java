package _solution.contest.weekly.w397;

import java.util.Arrays;

class No4 {

    boolean[] used;
    int[] nums;
    int n;
    int[] perm;
    int min = Integer.MAX_VALUE;
    int[] res;

    public int[] findPermutation(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        used = new boolean[n];
        perm = new int[n];

        dfs(0);

        return res;
    }

    private void dfs(int index) {
        if (index == n) {
            // 计算，取最小试试
            int score = calScore();
            if (score < min) {
                min = score;
                res = Arrays.copyOf(perm, n);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            int old = perm[index];
            perm[index] = i;
            used[i] = true;

            dfs(index + 1);

            perm[index] = old;
            used[i] = false;
        }
    }

    private int calScore() {
        int score = 0;
        for (int i = 0; i < n - 1; i++) {
            score += Math.abs(perm[i] - nums[perm[i + 1]]);
        }
        score += Math.abs(perm[n - 1] - nums[perm[0]]);
        return score;
    }

}
