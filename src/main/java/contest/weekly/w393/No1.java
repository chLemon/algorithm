package contest.weekly.w393;

class No1 {

    public String findLatestTime(String s) {
        char[] chars = s.toCharArray();
        char c0 = chars[0];
        if (c0 == '?') {
            // 最多到11点
            if (chars[1] != '?') {
                if (chars[1] > '1') {
                    chars[0] = '0';
                } else {
                    chars[0] = '1';
                }
            } else {
                chars[0] = '1';
            }
        }
        if (chars[1] == '?') {
            if (chars[0] == '0') {
                chars[1] = '9';
            } else {
                chars[1] = '1';
            }
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return new String(chars);
    }
}
