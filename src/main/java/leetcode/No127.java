package leetcode;

import java.util.*;

public class No127 {

    public static void main(String[] args) {
        No127 no = new No127();
        int i = no.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        int res = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            res += 1;
            for (int q = queue.size(); q > 0; q--) {
                String poll = queue.poll();
                visited.add(poll);
                if (poll.equals(endWord)) {
                    return res;
                }

                char[] charArray = poll.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char c = charArray[i];
                    for (int j = 0; j < 26; j++) {
                        if (c != j + 'a') {
                            charArray[i] = (char) ('a' + j);
                            String newString = new String(charArray);
                            if (wordSet.contains(newString) && !visited.contains(newString)) {
                                queue.offer(newString);
                            }
                        }
                    }
                    charArray[i] = c;
                }
            }
        }
        return 0;
    }

}
