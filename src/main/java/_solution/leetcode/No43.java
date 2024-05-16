package _solution.leetcode;

class No43 {

    int[] res;
    int[] n1;
    int[] n2;
    String num1;
    String num2;
    int m;
    int n;

    public static void main(String[] args) {
        System.out.println(new No43().multiply("0", "0"));
    }

    public String multiply(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.m = num1.length();
        this.n = num2.length();
        this.res = new int[m + n];
        this.n1 = new int[m + 1];
        this.n2 = new int[n + 1];
        for (int i = 0; i < m; i++) {
            n1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            n2[i] = num2.charAt(i) - '0';
        }

        for (int i = n - 1; i >= 0; i--) {
            multiplyAndAdd(i);
        }

        int start = 0;
        while (res[start] == 0) {
            start++;
        }

        char[] ss = new char[res.length - start];
        for (int i = start; i < res.length; i++) {
            ss[i] = (char) (res[i] + '0');
        }
        return new String(ss);
    }

    private void multiplyAndAdd(int index) {
        int carry = 0;
        int rIndex = res.length - n + index;

        int i = m - 1;
        int multi = n2[index];
        while (carry > 0 || i >= 0) {
            int value = i >= 0 ? n1[i] : 0;
            int tmp = value * multi + carry + res[rIndex];
            res[rIndex] = tmp % 10;
            carry = tmp / 10;
            i--;
            rIndex--;
        }
    }

}
