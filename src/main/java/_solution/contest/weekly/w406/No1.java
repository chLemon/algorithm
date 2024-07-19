package _solution.contest.weekly.w406;

public class No1 {

    public static void main(String[] args) {
        String s = new No1().getSmallestString("45320");
        System.out.println(s);
    }

    public String getSmallestString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n - 1; i++) {
            // 看当前值和下一个值能否交换
            int cur = chars[i] - '0';
            int next = chars[i + 1] - '0';

            boolean curOdd = (cur & 1) == 1;
            boolean nextOdd = (next & 1) == 1;
            if (cur > next && curOdd == nextOdd) {
                char tmp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = tmp;
                return new String(chars);
            }
        }
        return s;
    }

}
