package _solution.leetcode;

class No738 {

    public int monotoneIncreasingDigits(int n) {
        // 还可以直接用String，不需要用int[]

        // 从左往右，找到第一个不递增的位置，然后直接-1后面变9，注意相等的情况要特殊处理
        int[] digits = new int[10];
        int i = 0;
        while (n != 0) {
            digits[i] = n % 10;
            n /= 10;
            i++;
        }
        // i是最高位数，i-1是最高位index
        int changeStart = i - 1;
        for (int j = i - 1; j >= 1; j--) {
            int high = digits[j];
            int low = digits[j - 1];
            if (high > low) {
                // 出现了，changeStart -1 然后后面都是9
                digits[changeStart] -= 1;
                for (int start = changeStart - 1; start >= 0; start--) {
                    digits[start] = 9;
                }
            } else if (high == low) {
                // changeStart不变
            } else {
                // 共同后移
                changeStart = j - 1;
            }
        }

        int res = 0;
        int base = 1;
        for (int j = 0; j < digits.length; j++) {
            res += digits[j] * base;
            base *= 10;
        }

        return res;
    }

    // 数字单调，则必然是 a0 a1 a2 a3 ...
    // 显然可以拆分为  a0 * 111111... + (a1 - a0) * 1111... +...
    public int monotoneIncreasingDigits2(int n) {
        int base = 111_111_111;
        int res = 0;
        // 由于单个位置上最多到9，则最多循环9次
        for (int i = 0; i < 9 && base > 0; i++) {
            while (res + base > n) {
                base /= 10;
            }
            res += base;
        }
        return res;
    }
}
