package _solution.contest.weekly.w394;

class No2 {

    public static void main(String[] args) {
        new No2().numberOfSpecialChars("aaAbcBC");
    }

    public int numberOfSpecialChars(String word) {
        // 初始为0，出现了小写字母，记为1，如果出现了大写字母1可以转为2，如果又出现了小写，则为-1
        int[] flag = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                int j = c - 'a';

                if (flag[j] == 0) {
                    flag[j] = 1;
                } else if (flag[j] == 2) {
                    flag[j] = -1;
                }
            } else {
                int j = c - 'A';

                if (flag[j] == 0) {
                    flag[j] = -1;
                } else if (flag[j] == 1) {
                    flag[j] = 2;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (flag[i] == 2) {
                count++;
            }
        }
        return count;

    }

}
