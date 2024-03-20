package leetcode;

import java.util.*;

public class No17 {

    List<String> res = new ArrayList<>();
    Map<Character, List<Character>> keyboard = new HashMap<>();

    public static void main(String[] args) {
        No17 no = new No17();
        List<String> strings = no.letterCombinations("");
        System.out.println(strings);
    }

    // 回溯法
    public List<String> letterCombinations1(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        keyboard.put('2', Arrays.asList('a', 'b', 'c'));
        keyboard.put('3', Arrays.asList('d', 'e', 'f'));
        keyboard.put('4', Arrays.asList('g', 'h', 'i'));
        keyboard.put('5', Arrays.asList('j', 'k', 'l'));
        keyboard.put('6', Arrays.asList('m', 'n', 'o'));
        keyboard.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyboard.put('8', Arrays.asList('t', 'u', 'v'));
        keyboard.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        StringBuilder path = new StringBuilder();
        backtracking(digits, 0, path);

        return res;
    }

    private void backtracking(String digits, int index, StringBuilder path) {
        if (index >= digits.length()) {
            res.add(path.toString());
            return;
        }
        List<Character> words = keyboard.get(digits.charAt(index));
        for (Character w : words) {
            path.append(w);
            backtracking(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    // 遍历
    public List<String> letterCombinations(String digits) {
        keyboard.put('2', Arrays.asList('a', 'b', 'c'));
        keyboard.put('3', Arrays.asList('d', 'e', 'f'));
        keyboard.put('4', Arrays.asList('g', 'h', 'i'));
        keyboard.put('5', Arrays.asList('j', 'k', 'l'));
        keyboard.put('6', Arrays.asList('m', 'n', 'o'));
        keyboard.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyboard.put('8', Arrays.asList('t', 'u', 'v'));
        keyboard.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        Queue<String> res = new LinkedList<>();
        for (int i = 0; i < digits.toCharArray().length; i++) {
            char c = digits.charAt(i);
            List<Character> words = keyboard.get(c);
            if (res.isEmpty()) {
                for (Character w : words) {
                    res.offer(w + "");
                }
            } else {
                for (int j = res.size(); j > 0; j--) {
                    String pre = res.poll();
                    for (Character w : words) {
                        res.offer(pre + w);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

}
