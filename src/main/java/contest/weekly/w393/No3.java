package contest.weekly.w393;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class No3 {

    public static void main(String[] args) {
        No3 no = new No3();
        System.out.println(no.findKthSmallest(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                (int) (2 * 10e9)));
    }

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        Set<Integer> coinSet = removeCoins(coins);
        coins = coinSet.stream().mapToInt(a -> a).toArray();
        Arrays.sort(coins);

        long minProduct = getMinProduct(coins);

        long setNumber = getMinSetCount(coins, minProduct);

        long n = k / setNumber;
        long m = k % setNumber;

        long base = n * minProduct;
        long number = 0;
        for (int i = 0; i < m; i++) {
            TreeSet<Long> set = new TreeSet<>();
            for (int coin : coins) {
                for (int j = 1; j < minProduct / coin; j++) {
                    set.add((long) coin * j);
                }
            }
            set.add(minProduct);
        }
        return base + number;
    }

    private long getMinSetCount(int[] coins, long minProduct) {
        long sum = 0;
        for (int coin : coins) {
            sum += minProduct / coin + 1;
        }
        return sum;
    }

    private Set<Integer> removeCoins(int[] coins) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> maybe = new HashSet<>();
        for (int coin : coins) {
            if (maybe.contains(coin)) {
                continue;
            } else {
                set.add(coin);
                if (coin != 1) {
                    for (int i = 1; i <= 25; i++) {
                        maybe.add(coin * i);
                    }
                }
            }
        }
        return set;
    }

    private TreeSet<Long> getMinSet(int[] coins, long minProduct) {
        TreeSet<Long> set = new TreeSet<>();
        for (int coin : coins) {
            for (int i = 1; i < minProduct / coin; i++) {
                set.add((long) coin * i);
            }
        }
        set.add(minProduct);
        return set;
    }

    private long getMinProduct(int[] coins) {
        long minProduct = coins[0];
        for (int i = 1; i <= coins.length - 1; i++) {
            // 求
            minProduct = getMinProduct(minProduct, coins[i]);
        }
        return minProduct;
    }

    private long getMinProduct(long a, long b) {
        long gcd = gcd(a, b);
        return a / gcd * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
