package _solution.leetcode;

import java.util.Arrays;

public class No486 {

    int[] nums;
    int[][][] cache;

    public static void main(String[] args) {
        System.out.println(new No486().predictTheWinner2(new int[]{2, 4, 55, 6, 8}));
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        cache = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }

        int[] res = predictTheWinner(0, nums.length - 1);

        return res[0] >= res[1];
    }

    // [l, r]时，作为先手，能拿的最大分数，和对应的后手分数
    private int[] predictTheWinner(int l, int r) {
        if (cache[l][r][0] != -1) return cache[l][r];
        if (l == r) {
            cache[l][r][0] = nums[l];
            cache[l][r][1] = 0;
            return new int[]{nums[l], 0};
        }
        if (l + 1 == r) {
            cache[l][r][0] = Math.max(nums[l], nums[r]);
            cache[l][r][1] = Math.min(nums[l], nums[r]);
            return new int[]{Math.max(nums[l], nums[r]), Math.min(nums[l], nums[r])};
        }
        if (l + 1 > r) {
            cache[l][r][0] = 0;
            cache[l][r][1] = 0;
            return new int[]{0, 0};
        }
        /*
        可能性：
        1 先手 左，后手 左/右
        2 先手 右，后手 左/右
        要找到后手选择最大的情况下，先手最大的情况
         */
        // 1
        // 后手最优策略
        int b1 = predictTheWinner(l + 1, r)[0];
        int a1 = nums[l] + predictTheWinner(l + 1, r)[1];

        // 2
        int b2 = predictTheWinner(l, r - 1)[0];
        int a2 = nums[r] + predictTheWinner(l, r - 1)[1];
        if (a1 > a2) {
            cache[l][r][0] = a1;
            cache[l][r][1] = b1;
            return new int[]{a1, b1};
        } else {
            cache[l][r][0] = a2;
            cache[l][r][1] = b2;
            return new int[]{a2, b2};
        }
    }

    public boolean predictTheWinner2(int[] nums) {
        int n = nums.length;
        int[][][] f = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            f[i][i][0] = nums[i];
            if (i + 1 < n) {
                f[i][i + 1][0] = Math.max(nums[i], nums[i + 1]);
                f[i][i + 1][1] = Math.min(nums[i], nums[i + 1]);
            }
        }
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                int b1 = f[l + 1][r][0];
                int a1 = nums[l] + f[l + 1][r][1];

                int b2 = f[l][r - 1][0];
                int a2 = nums[r] + f[l][r - 1][1];
                if (a1 > a2) {
                    f[l][r][0] = a1;
                    f[l][r][1] = b1;
                } else {
                    f[l][r][0] = a2;
                    f[l][r][1] = b2;
                }
            }
        }

        return f[0][n - 1][0] >= f[0][n - 1][1];
    }


}
