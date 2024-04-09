package programmercarl;

class No151 {

    public static void main(String[] args) {
        No151 no = new No151();
        no.reverseWords("the sky is blue");
    }


    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        // 先去除多余的空格
        boolean hasOneSpace = true;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                if (!hasOneSpace) {
                    hasOneSpace = true;
                } else {
                    continue;
                }
            } else {
                hasOneSpace = false;
            }
            chars[index++] = c;
        }
        // 去除结尾空格
        while (chars[index - 1] == ' ') {
            index--;
        }

        // reverse all
        reverse(chars, 0, index - 1);

        // reverse word
        int wordStart = 0;
        for (int wordEnd = 0; wordEnd < index; wordEnd++) {
            if (chars[wordEnd] == ' ') {
                reverse(chars, wordStart, wordEnd - 1);
                wordStart = wordEnd + 1;
            }
        }
        reverse(chars, wordStart, index - 1);

        return new String(chars, 0, index);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    private void removeSpaces(char[] chars) {
        int slow = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {  // 非空格就处理
                if (slow != 0) chars[slow++] = ' '; // 不是第一个时，手动给单词之间加空格
                while (i < chars.length && chars[i] != ' ') chars[slow++] = chars[i++]; // 补上单词
            }
        }
    }

}
