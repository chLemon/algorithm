package _solution.leetcode;

import java.util.*;

class No207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表
        int[] indegrees = new int[numCourses];
        // 邻接表
        Map<Integer, List<Integer>> node2Targets = new HashMap<>();
        for (int[] pre : prerequisites) {
            indegrees[pre[1]]++;
            node2Targets.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        // 所有入度为0的可以学习，入队
        Queue<Integer> canLearn = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) canLearn.offer(i);
        }
        while (!canLearn.isEmpty()) {
            int learned = canLearn.poll();
            List<Integer> courses = node2Targets.getOrDefault(learned, new ArrayList<>());
            for (Integer c : courses) {
                indegrees[c]--;
                if (indegrees[c] == 0) canLearn.offer(c);
            }
        }
        // 检查是否有 > 0 的入度
        for (int i : indegrees) {
            if (i > 0) return false;
        }
        return true;
    }

}
