package leetcode;

class No70 {

    public int climbStairs(int n) {
        if (n <= 3) return n;
        int lastLast = 2;
        int last = 3;
        int res = 0;
        for (int i = 4; i < n + 1; i++) {
            res = lastLast + last;
            lastLast = last;
            last = res;
        }
        return res;
    }

}
