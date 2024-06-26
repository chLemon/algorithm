package _solution.leetcode;

import java.util.ArrayList;
import java.util.List;

class No93 {

    /*
    有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

    例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     */
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        No93 no = new No93();
        List<String> strings = no.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        backTracing(s, 0);
        return res;
    }

    private void backTracing(String s, int start) {
        if (start >= s.length() && path.size() == 4) {
            res.add(String.join(".", path));
            return;
        }

        for (int i = start + 1; i <= start + 3 && i <= s.length(); i++) {
            if (s.length() - i > (3 - path.size()) * 3) {
                continue;
            }
            String split = s.substring(start, i);
            if (isValid(split)) {
                path.add(split);
                backTracing(s, i);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int i = Integer.parseInt(s);
        return i >= 0 && i <= 255;
    }

}
