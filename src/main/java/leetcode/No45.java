package leetcode;

import java.util.Arrays;

public class No45 {

    public static void main(String[] args) {
        No45 no = new No45();
        no.jump2(new int[]{2, 3, 1, 1, 4});
    }

    public int jump(int[] nums) {
        int[] f = new int[nums.length];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[nums.length - 1];
    }

    public int jump2(int[] nums) {
        if (nums.length == 1) return 0;
        int curMaxDistance = 0;
        int res = 0;
        int nextMaxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextMaxDistance = Math.max(i + nums[i], nextMaxDistance);
            if (nextMaxDistance >= nums.length - 1) {
                res++;
                break;
            }
            if (i >= curMaxDistance) {
                res++;
                curMaxDistance = nextMaxDistance;
            }
        }
        return res;
    }
}
