package _solution.leetcode;

import java.util.*;

class No841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer key : rooms.get(poll)) {
                if (!visited.contains(key)) {
                    queue.offer(key);
                    // 更推荐入队的时候做操作
                    visited.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
