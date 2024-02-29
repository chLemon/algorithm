package leetcode;

public class No541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int startIndex;
        for (startIndex = 0; startIndex < s.length(); startIndex += 2 * k) {
            // 当数了2k个后，翻转index到index+k-1的值
            reverse(chars, startIndex, Math.min(startIndex + k - 1, s.length() - 1));
        }
        return new String(chars);
    }

    private void reverse(char[] s, int startIndex, int endIndex) {
        for (; startIndex < endIndex; startIndex++, endIndex--) {
            char tmp = s[startIndex];
            s[startIndex] = s[endIndex];
            s[endIndex] = tmp;
        }
    }


}
