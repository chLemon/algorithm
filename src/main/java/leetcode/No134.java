package leetcode;

public class No134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int f = 0;
        int minF = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < gas.length; i++) {
            f += gas[i] - cost[i];
            if (f <= minF) {
                minIndex = i;
                minF = f;
            }
        }
        return f < 0 ? -1 : (minIndex + 1) % gas.length;
    }
}
