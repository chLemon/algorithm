package _solution.leetcode;

public class No211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new No211().new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad");
        wordDictionary.search("bad");
        wordDictionary.search(".ad");
        wordDictionary.search("b..");
    }

    class WordDictionary {

        TrieNode root = new TrieNode();

        public WordDictionary() {

        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (cur.tns[idx] == null) cur.tns[idx] = new TrieNode();
                cur = cur.tns[idx];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int start, TrieNode cur) {
            if (start == word.length()) return cur.isEnd;
            char c = word.charAt(start);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (cur.tns[i] != null && search(word, start + 1, cur.tns[i])) return true;
                }
                return false;
            } else {
                int idx = c - 'a';
                if (cur.tns[idx] == null) return false;
                return search(word, start + 1, cur.tns[idx]);
            }
        }

        class TrieNode {
            boolean isEnd;
            TrieNode[] tns = new TrieNode[26];
        }
    }
}