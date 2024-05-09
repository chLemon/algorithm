package _solution.leetcode;

class No1234 {

    public int balancedString(String s) {
        // 当除了窗口内，每个字符的出现次数，都小于等于 n/4，则可以
        // 这一大坨可以用hashmap或者一个够长的数组来代替
        int qCount = 0;
        int wCount = 0;
        int eCount = 0;
        int rCount = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'Q':
                    qCount++;
                    break;
                case 'W':
                    wCount++;
                    break;
                case 'E':
                    eCount++;
                    break;
                case 'R':
                    rCount++;
                    break;
            }
        }
        int m = s.length() / 4;
        if (qCount <= m && wCount <= m && eCount <= m && rCount <= m) return 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            switch (s.charAt(right)) {
                case 'Q':
                    qCount--;
                    break;
                case 'W':
                    wCount--;
                    break;
                case 'E':
                    eCount--;
                    break;
                case 'R':
                    rCount--;
                    break;
            }
            while (qCount <= m && wCount <= m && eCount <= m && rCount <= m) {
                minLen = Math.min(minLen, right - left + 1);
                switch (s.charAt(left++)) {
                    case 'Q':
                        qCount++;
                        break;
                    case 'W':
                        wCount++;
                        break;
                    case 'E':
                        eCount++;
                        break;
                    case 'R':
                        rCount++;
                        break;
                }
            }
        }
        return minLen;
    }

}
