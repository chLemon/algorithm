package _solution.leetcode;

public class No12 {

    public static void main(String[] args) {
        System.out.println(new No12().intToRoman(3749));
    }

    public String intToRoman(int num) {
        // num [1, 3999]
        int[] baseValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baseValues.length && num > 0; i++) {
            int base = baseValues[i];
            if (num >= base) {
                int count = num / base;
                for (int j = 0; j < count; j++) {
                    builder.append(symbols[i]);
                }
                num -= count * base;
            }
        }
        return builder.toString();
    }

}
