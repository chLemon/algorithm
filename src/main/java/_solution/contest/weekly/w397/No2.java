package _solution.contest.weekly.w397;

import java.util.Arrays;

public class No2 {

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] f = new int[n];
        for (int i = n - 1; i > n - 1 - k; i--) {
            f[i] = energy[i];
        }
        for (int i = n - 1 - k; i >= 0; i--) {
            f[i] = f[i + k] + energy[i];
        }
        return Arrays.stream(f).max().orElse(0);
    }

}
