package _solution.leetcode;

public class No69 {

    public static void main(String[] args) {
        new No69().mySqrt(2147483647);
    }

    public int mySqrt(int x) {
        long left = 0;
        long right = (long) x + 1;
        while (left < right) {
            long mid = left + right >>> 1;
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 循环不变量 left - 1 平方后 < x
        // right 平方后 > x
        // left = right 
        return (int) (left - 1);
    }
}
