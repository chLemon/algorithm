package solutions.codinginterviews;

import org.junit.Test;

import java.util.*;

public class No38 {
    /*
    输入一个字符串，打印出该字符串中字符的所有排列。
    你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     */
    ArrayList<String> result;
    char[] chars;

    public String[] permutation(String s) {
        //全排列，递归
        //这道题可能存在的问题应该就是，s里面可能会有重复的字符。

        chars = s.toCharArray();
        result = new ArrayList<String>();

        recur(0);

        return result.toArray(new String[result.size()]);
    }

    public void swap(int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public void recur(int layer) {
        if (layer == chars.length-1) {
            result.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = layer; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);

            swap(i, layer);

            recur(layer + 1);
            swap(i, layer);
        }
    }

    @Test
    public void test() {
        permutation("abc");
    }
}
