package _solution.contest.weekly.w399;

import javax.lang.model.type.ErrorType;

public class No2 {

    public static void main(String[] args) {
        System.out.println(new No2().compressedString("aaaaaaaaaaaaaabb"));
    }

    public String compressedString(String word) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int start = i;
        char c = 0;
        while (i < word.length()) {
            c = word.charAt(start);
            while (i < word.length() && word.charAt(i) == c
                    && i - start <= 8) {
                i++;
                // i 最终 != c
            }
            builder.append(i - start);
            builder.append(c);
            start = i;
        }
        return builder.toString();
    }
}
