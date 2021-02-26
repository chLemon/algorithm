package weeklycontest.no202;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No4 {
    Map<Integer, Integer> map = new HashMap();

    public int minDays3(int n) {
        if(n == 0){
            return 0;
        }
        if(!map.containsKey(n)){
            int ans = n;
            int half = n / 2;
            int third = n / 3;
            ans = Math.min(ans, minDays(half) + 1 + n - half * 2);
            ans = Math.min(ans, minDays(third) + 1 + n - third * 3);
            map.put(n, ans);
        }
        return map.get(n);
    }

    public int minDays(int n) {
        if (n == 0) {
            return 0;
        }
        int[] mindays = new int[n + 1];
        mindays[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            //plan 1 plan 2 plan 3
            int p1 = mindays[i - 1] + 1;
            int p2 = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                p2 = mindays[i / 2] + 1;
            }
            int p3 = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                p3 = mindays[i / 3] + 1;
            }
            mindays[i] = Math.min(Math.min(p1, p2), p3);
        }
        return mindays[n];
    }

    public int minDays2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 2;
        }
        //plan 1 plan 2 plan 3
        int p1 = minDays2(n - 1) + 1;
        int p2 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            p2 = minDays2(n / 2) + 1;
        }
        int p3 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            p3 = minDays2(n / 3) + 1;
        }
       return Math.min(Math.min(p1, p2), p3);
    }

    @Test
    public void test() {
        minDays(10);
    }
}
