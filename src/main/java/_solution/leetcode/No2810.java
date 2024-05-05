package _solution.leetcode;

class No2810 {

    public static void main(String[] args) {
        No2810 no = new No2810();
        String s = no.finalString("string");
        System.out.println(s);
    }

    public String finalString(String s) {
        int index = 0;
        char[] chars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (s.charAt(i) != 'i') {
                chars[index++] = s.charAt(i);
            } else {
                reverse(chars, 0, index - 1);
            }
        }
        return new String(chars, 0, index);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start <= end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

}
