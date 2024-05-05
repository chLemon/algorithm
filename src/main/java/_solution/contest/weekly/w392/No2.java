package _solution.contest.weekly.w392;

class No2 {

    int k;

    public static void main(String[] args) {
        String zbbz = new No2().getSmallestString("xaxcd", 4);
        System.out.println(zbbz);
    }

    public String getSmallestString(String s, int k) {
        this.k = k;
        // 优先变第一个，消耗k
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char res = change(chars[i]);
            chars[i] = res;
            if (this.k <= 0) {
                break;
            }
        }
        return new String(chars);
    }

    // c在k距离内变为最小
    private char change(char c) {
        // 距离a的距离
        int toA = Math.min(c - 'a', 'z' - c + 1);
        if (this.k >= toA) {
            this.k -= toA;
            return 'a';
        }
        char c1 = (char) (c - this.k);
        this.k = 0;
        return c1;
    }

}
