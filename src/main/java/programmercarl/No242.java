package programmercarl;

class No242 {

    public boolean isAnagram(String s, String t) {
        int[] sFrequency = new int[26];
        // 同一个数组加加减减就可以，最后判断全0
        int[] tFrequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sFrequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tFrequency[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sFrequency[i] != tFrequency[i]) {
                return false;
            }
        }
        return true;
    }

}
