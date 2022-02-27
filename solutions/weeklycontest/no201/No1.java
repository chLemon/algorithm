package weeklycontest.no201;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No1 {
    /*
    给你一个由大小写英文字母组成的字符串 s 。

一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：

0 <= i <= s.length - 2
s[i] 是小写字符，但 s[i + 1] 是对应的大写字符；反之亦然 。
请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。

请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。

注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
     */
    boolean b = true;

    public String makeGood(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        while (b) {
            minusChar(list);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public void minusChar(ArrayList<Character> list) {
        b = false;
        if (list.size() <= 1) {
            return;
        }
        for (int i = 0; i <= list.size() - 2; i++) {
            char cur = list.get(i);
            char next = list.get(i + 1);
            if ('a' <= cur && cur <= 'z') {
                //cur是小写
                if (next == cur - 'a' + 'A') {
                    //next是对应的大写
                    b = true;
                    list.remove(i + 1);
                    list.remove(i);
                } else {
                    //next是大写
                    continue;
                }
            } else {
                //cur是大写
                if (next == cur - 'A' + 'a') {
                    //next是对应的小写
                    b = true;
                    list.remove(i + 1);
                    list.remove(i);
                } else {
                    continue;
                }
            }
        }
    }

    @Test
    public void test() {
        String s = makeGood("leEeetcode");
        System.out.println(s);
    }
}
