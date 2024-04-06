package programmercarl;

import java.util.Arrays;

class No977 {

    public static void main(String[] args) {
        No977 no = new No977();
        int[] ints = no.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int minNegative = nums.length - 1;
        int minPositive = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                minPositive = i;
                minNegative = i - 1;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int base = 0;
            if (minNegative >= 0 && minPositive < nums.length) {
                // 取其中绝对值最小的
                if (-nums[minNegative] > nums[minPositive]) {
                    base = nums[minPositive++];
                } else {
                    base = nums[minNegative--];
                }
            } else if (minNegative >= 0) {
                base = nums[minNegative--];
            } else {
                base = nums[minPositive++];
            }
            res[i] = base * base;
        }
        return res;
    }

}
