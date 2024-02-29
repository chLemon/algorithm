package leetcode;

public class No151 {

    public static void main(String[] args) {
        No151 no = new No151();
        String s = no.reverseWords("a good  example");
        System.out.println(s);
    }
    
    public String reverseWords(String s) {
        // 空间O1的话，先去除空格，再全部翻转，然后挨着翻转单词。但是java不可能空间O1，所以：
        // 从末尾开始，将单词加入到builder
        StringBuilder builder = new StringBuilder();
        int wordLast = s.length() - 1;
        int wordStart;

        while (wordLast >= 0) {
            while (wordLast >= 0 && s.charAt(wordLast) == ' ') wordLast--;
            wordStart = wordLast;
            while (wordStart >= 0 && s.charAt(wordStart) != ' ') wordStart--;
            wordStart++;
            if (wordStart <= wordLast) {
                builder.append(s, wordStart, wordLast + 1);
                builder.append(" ");
            }
            wordLast = wordStart - 2;
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

}
