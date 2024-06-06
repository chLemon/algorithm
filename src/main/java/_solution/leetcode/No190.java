package _solution.leetcode;

public class No190 {
    public static void main(String[] args) {
        int M1 = 0x55555555;
        int n = 0b01010101;
        System.out.println(Integer.toBinaryString(n));
        n = n >>> 1 & M1 | (n & M1) << 1;
        System.out.println(Integer.toBinaryString(n));
    }
}
