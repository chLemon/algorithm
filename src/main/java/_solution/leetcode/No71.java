package _solution.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No71 {

    public static void main(String[] args) {
        System.out.println(new No71().simplifyPath("/home/"));
    }

    public String simplifyPath(String path) {
        int n = path.length();

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            while (i < n && path.charAt(i) == '/') {
                i++;
            }
            if (i >= n) break;
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }
            // i != / j = /
            String s = path.substring(i, j);
            switch (s) {
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                    break;
                case ".":
                    break;
                default:
                    stack.offerLast(s);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
