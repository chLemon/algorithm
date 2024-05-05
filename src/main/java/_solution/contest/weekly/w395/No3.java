package _solution.contest.weekly.w395;

class No3 {

    public long minEnd(int n, int x) {
        long res = x;

        for (int i = 0; i < n - 1; i++) {
            res = res + 1;
            res = res | x;
        }
        return res;
    }

}
