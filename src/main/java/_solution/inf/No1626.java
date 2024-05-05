package _solution.inf;

import java.util.Arrays;

class No1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        // 按照分数排序
        int n = scores.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) ->
                // 按照分数排序
                scores[i] == scores[j] ? Integer.compare(ages[i], ages[j])
                        : Integer.compare(scores[i], scores[j])

        );

        // 按照分数排序后，从ages中选择一个递增子序列
        int[] f = new int[n];   // f[i] 以ages[i]结尾的，递增子序列的最大得分
        f[0] = scores[ids[0]];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (ages[ids[j]] <= ages[ids[i]]) {
                    max = Math.max(max, f[j]);
                }
            }
            f[i] = max + scores[ids[i]];
        }
        return Arrays.stream(f).max().orElse(0);
    }

}
