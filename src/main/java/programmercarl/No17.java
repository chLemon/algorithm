package programmercarl;

import java.util.*;

class No17 {

    Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        dfs(res, builder, digits, 0);

        return res;
    }

    private void dfs(List<String> res, StringBuilder builder, String digits, int i) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(i);
        List<Character> list = map.get(c);
        for (Character character : list) {
            builder.append(character);
            dfs(res, builder, digits, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


}
