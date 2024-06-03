package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No68 {

    String[] words;
    int maxWidth;
    int n;

    public static void main(String[] args) {
        String[] ss = {"As", "long", "as", "ever", "you", "can."};
        new No68().fullJustify(ss, 26);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        this.maxWidth = maxWidth;

        List<String> res = new ArrayList<>();
        n = words.length;

        int left = 0;
        int sum = 0;
        int i = 0;
        for (; i < n; i++) {
            String w = words[i];
            if (sum + w.length() > maxWidth) {
                String t;
                if (i - left == 1) {
                    t = buildLeft(left, i, sum - (i - left));
                } else {
                    t = build(left, i, sum - (i - left));
                }
                res.add(t);
                sum = w.length() + 1;
                left = i;
            } else {
                sum += w.length() + 1;
            }
        }
        String t = buildLeft(left, i, sum - (i - left));
        res.add(t);
        return res;
    }

    private String buildLeft(int left, int right, int wordCount) {
        // 左对齐
        StringBuilder sb = new StringBuilder();
        int putSize = 0;
        for (int i = left; i < right; i++) {
            sb.append(words[i]);
            putSize += words[i].length();

            if (putSize < maxWidth) {
                sb.append(" ");
                putSize += 1;
            }
        }
        while (putSize++ < wordCount) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String build(int left, int right, int wordCount) {
        int wc = right - left;
        int totalSpace = maxWidth - wordCount;
        int eachSpace = totalSpace / (wc - 1);
        int buffer = totalSpace - eachSpace * (wc - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = left; i < right; i++) {
            sb.append(words[i]);
            if (i != right - 1) {
                for (int j = 0; j < eachSpace; j++) {
                    sb.append(" ");
                }
                if (buffer-- > 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

}
