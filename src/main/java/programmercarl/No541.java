package programmercarl;

class No541 {

    public static void main(String[] args) {
        No541 no = new No541();
        no.reverseStr("abcdefg", 8);
    }

    /*
        char[] chars = s.toCharArray();
        int startIndex;
        for (startIndex = 0; startIndex < s.length(); startIndex += 2 * k) {
            // 当数了2k个后，翻转index到index+k-1的值
            reverse(chars, startIndex, Math.min(startIndex + k - 1, s.length() - 1));
        }
        return new String(chars);
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int zIndex = 0;
        int kIndex = k - 1;
        int k2Index = 2 * k - 1;
        while (k2Index <= s.length() - 1) {
            reverse(chars, zIndex, kIndex);
            zIndex += 2 * k;
            kIndex += 2 * k;
            k2Index += 2 * k;
        }
        kIndex = Math.min(kIndex, s.length() - 1);
        reverse(chars, zIndex, kIndex);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        if (start >= chars.length - 1) return;
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

}
