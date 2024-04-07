package programmercarl;

import java.util.HashSet;
import java.util.Set;

class No202 {

    public boolean isHappy(int n) {
        Set<Integer> occurred = new HashSet<>();
        while (n != 1 && !occurred.contains(n)) {
            occurred.add(n);
            n = next(n);
        }
        return n == 1;
    }

    private int next(int n) {
        int res = 0;
        while (n != 0) {
            int i = n % 10;
            res += i * i;
            n /= 10;
        }
        return res;
    }
}
