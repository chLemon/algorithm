package _solution.programmercarl;

class No738 {

    public static void main(String[] args) {
        No738 no = new No738();
        no.monotoneIncreasingDigits(10);
    }

    public int monotoneIncreasingDigits(int n) {
        int store = n;
        int[] number = new int[10];
        int high = 0;
        while (n != 0) {
            number[high++] = n % 10;
            n /= 10;
        }
        // high指向最高位+1
        int change = -1;
        for (int i = 0; i < high - 1; i++) {
            if (number[i] < number[i + 1]) {
                number[i + 1]--;
                change = i + 1;
            }
        }
        if (change == -1) return store;
        // change指向需要-1的最高位
        for (int i = 0; i < change; i++) {
            number[i] = 9;
        }
        int res = 0;
        for (int i = high - 1; i >= 0; i--) {
            res *= 10;
            res += number[i];
        }
        return res;
    }

}
