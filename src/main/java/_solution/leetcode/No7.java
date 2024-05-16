package _solution.leetcode;

public class No7 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int last = res;
            int t = x % 10;
            res = res * 10 + t;
            if (res / 10 != last) return 0;
            x = x / 10;
        }
        return res;
    }

}
