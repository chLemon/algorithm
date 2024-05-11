package _solution.contest.biweekly.w130;

import java.util.*;

public class No2 {

    public static void main(String[] args) {
        System.out.println(new No2().maxPointsInsideSquare(new int[][]{
                {2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}
        }, "abdca"));
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        // 在d这个正方形上的点的个数
        TreeMap<Integer, Set<Character>> d2Count = new TreeMap<>();
        TreeSet<Integer> failD = new TreeSet<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int d = Math.max(Math.abs(point[0]), Math.abs(point[1]));
            if (failD.contains(d)) {
                continue;
            }
            Set<Character> set = d2Count.computeIfAbsent(d, k -> new HashSet<>());
            if (set.contains(s.charAt(i))) {
                failD.add(d);
            } else {
                set.add(s.charAt(i));
            }
        }
        Integer failedFirst = failD.isEmpty() ? null : failD.first();
        failedFirst = failedFirst == null ? Integer.MAX_VALUE : failedFirst;
        boolean[] occur = new boolean[26];
        int sum = 0;
        for (Map.Entry<Integer, Set<Character>> entry : d2Count.entrySet()) {
            if (entry.getKey() >= failedFirst) {
                break;
            }

            Set<Character> value = entry.getValue();
            boolean wrong = false;
            for (Character c : value) {
                if (occur[c - 'a']) {
                    wrong = true;
                    break;
                }
                occur[c - 'a'] = true;
            }
            if (!wrong) {
                sum += value.size();
            } else {
                break;
            }
        }
        return sum;
    }
}
