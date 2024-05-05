package _solution.inf;

import java.util.ArrayList;
import java.util.List;

class No1671 {

    int[] nums;

    public static void main(String[] args) {
        System.out.println(new No1671().minimumMountainRemovals(new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64}));
    }

    public int minimumMountainRemovals(int[] nums) {
        this.nums = nums;
        // 最大子序列，山形，枚举封顶
        int ans = 0;

        int[] leftRes = getLeftRes();
        int[] rightRes = getRightMax();

        // 这里就要保存一下了
        for (int i = 1; i <= nums.length - 2; i++) {
            int left = leftRes[i];
            int right = rightRes[i];
            // 必须要在 都 >=2 的时候，才是山
            if (left >= 2 && right >= 2) {
                ans = Math.max(ans, left + right - 1);
            }
        }
        return nums.length - ans;
    }

    private int[] getLeftRes() {
        int[] res = new int[nums.length];
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i];
            int j = lowerBound(g, x);
            if (j == g.size()) {
                g.add(x);
            } else {
                g.set(j, x);
            }
            // x结尾的 最大严格递减子序列长度为 j + 1
            res[i] = j + 1;
        }
        return res;
    }

    // 最大严格递减子序列。这个方法应该将结果在遍历的过程中保存起来。
    private int[] getRightMax() {
        int[] res = new int[nums.length];
        // 这里用 nlog(n)
        // 定义 g[i] 为 长度 i + 1 的子串的 最小结尾
        List<Integer> g = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            int j = lowerBound(g, x);
            if (j == g.size()) {
                g.add(x);
            } else {
                g.set(j, x);
            }
            // x结尾的 最大严格递减子序列长度为 j + 1
            res[i] = j + 1;
        }
        return res;
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

    // 最大严格递增子序列
    private int getLeftMax(int peek) {
        // 这里用 n^2
        int[] f = new int[peek + 1];    // f[i]表示，以i结尾，最长严格等增子序列的长度
        f[0] = 1;
        for (int i = 1; i <= peek; i++) {
            int res = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res = Math.max(res, f[j]);
                }
            }
            f[i] = res + 1;
        }
        return f[peek];
    }

}
