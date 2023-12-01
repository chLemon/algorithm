package leetcode;

import java.util.HashSet;
import java.util.Set;

public class No202 {

    public boolean isHappy(int n) {
        Set<Integer> occurred = new HashSet<>();
        while (n != 1 && !occurred.contains(n)) {
            occurred.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }
}
