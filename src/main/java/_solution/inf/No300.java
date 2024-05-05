package _solution.inf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class No300 {

    int[] nums;
    Map<Integer, Integer> cache = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> cache2 = new HashMap<>();

    // 贪心+二分
    public int lengthOfLIS2(int[] nums) {
        // g[i] 长为 i + 1 的子序列，结尾值的最小值
        List<Integer> g = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = lowerBound(g, nums[i]);
            if (j == g.size()) {
                g.add(nums[i]);
            } else {
                g.set(j, nums[i]);
            }
        }

        return g.size();
    }

    private int lowerBound(List<Integer> g, int target) {
        int left = 0;
        int right = g.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (g.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /*
    枚举选哪个的思路1。dfs(i)表示，上次选了i，不含i的LIS
     */
    public int lengthOfLIS(int end) {
        if (cache.get(end) != null) return cache.get(end);
        int ans = 0;
        for (int i = 0; i < end; i++) {
            if (end >= nums.length || nums[i] < nums[end]) {
                ans = Math.max(ans, lengthOfLIS(i) + 1);
            }
        }
        cache.put(end, ans);
        return ans;
    }

    /*
    枚举选哪个的思路2。dfs(i)表示，以i结尾的LIS
     */
    public int lengthOfLIS2(int i) {
        if (cache.get(i) != null) return cache.get(i);
        int ans = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                ans = Math.max(ans, lengthOfLIS2(j));
            }
        }
        cache.put(i, ans);
        return ans + 1;
    }

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        // 子集型问题，2个思路，选和不选，选哪个

        // 选哪个
//        return lengthOfLIS(nums.length);
        /*
        选哪个 改造成递推
        dfs(i) = Math.max( dfs(j) ) +1  0<= j < i && nums[j] < nums[i]
         */

//        int n = nums.length;
//        int[] f = new int[n + 1];   // f[i] 表示，不含i的情况下，可以取到的最大值
//        f[0] = 0;
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 0; j < i; j++) {
//                if (i >= n || nums[j] < nums[i]) {
//                    f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//        }
//        return f[n];

//
//        int n = nums.length;
//        int[] f = new int[n];   // f[i] 以i结尾的LIS
//        f[0] = 1;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    f[i] = Math.max(f[i], f[j]);
//                }
//            }
//            f[i] += 1;
//        }
//        return Arrays.stream(f).max().orElse(0);

        /**
         * 选和不选。会超时
         */

        return lengthOfLIS2(nums.length - 1, nums.length);
    }

    private int lengthOfLIS2(int now, int last) {
        if (cache2.getOrDefault(now, new HashMap<>()).get(last) != null) {
            return cache2.get(now).get(last);
        }
        if (now < 0) {
            return 0;
        }
        int ans = 0;
        if (last >= nums.length || nums[now] < nums[last]) {
            // 可以选
            ans = Math.max(ans, lengthOfLIS2(now - 1, now) + 1);
        }

        // 可以不选
        ans = Math.max(ans, lengthOfLIS2(now - 1, last));
        cache2.computeIfAbsent(now, k -> new HashMap<>()).put(last, ans);
        return ans;
    }

}
