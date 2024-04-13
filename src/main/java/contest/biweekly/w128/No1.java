package contest.biweekly.w128;

public class No1 {

    public int scoreOfString(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            sum += Math.abs(chars[i] - chars[i - 1]);
        }
        return sum;
    }

}
