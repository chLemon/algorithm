package _solution.contest.weekly.w393;

import java.util.HashSet;
import java.util.Set;

class No2 {

    public int maximumPrimeDifference(int[] nums) {
        // 预处理得到所有的素数
        Set<Integer> primes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        int first = -1;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (primes.contains(nums[i])) {
                first = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (primes.contains(nums[i])) {
                last = i;
                break;
            }
        }

        return last - first;
    }

    private boolean isPrime(int i) {
        if (i == 1) return false;
        if (i <= 3) return true;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

}
