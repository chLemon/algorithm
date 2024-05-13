package _solution.leetcode;

public class No8 {

    public static void main(String[] args) {
        System.out.println(new No8().myAtoi(""));
    }

    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        // 去除前导空格
        while (i < n && s.charAt(i) == ' ') i++;
        boolean negtive = false;
        if (i < n && s.charAt(i) == '-') {
            negtive = true;
        }
        // 去除符号位
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        // 开始计算数字
        long v = 0;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            v = v * 10 + s.charAt(i) - '0';
            i++;
            if (!negtive && v > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (negtive && -v < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) v * (negtive ? -1 : 1);
    }
}
