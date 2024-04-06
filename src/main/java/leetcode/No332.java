package leetcode;

import com.fasterxml.jackson.core.type.TypeReference;
import util.JacksonUtil;

import java.util.*;

class No332 {

    List<String> path = new ArrayList<>();
    Map<String, TreeMap<String, Integer>> start2End = new HashMap<>();

    public static void main(String[] args) {
        No332 no = new No332();
        String s = "[[\"EZE\",\"TIA\"],[\"EZE\",\"HBA\"],[\"AXA\",\"TIA\"],[\"JFK\",\"AXA\"],[\"ANU\",\"JFK\"],[\"ADL\",\"ANU\"],[\"TIA\",\"AUA\"],[\"ANU\",\"AUA\"],[\"ADL\",\"EZE\"],[\"ADL\",\"EZE\"],[\"EZE\",\"ADL\"],[\"AXA\",\"EZE\"],[\"AUA\",\"AXA\"],[\"JFK\",\"AXA\"],[\"AXA\",\"AUA\"],[\"AUA\",\"ADL\"],[\"ANU\",\"EZE\"],[\"TIA\",\"ADL\"],[\"EZE\",\"ANU\"],[\"AUA\",\"ANU\"]]";
        List<List<String>> lists = JacksonUtil.readValue(s, new TypeReference<List<List<String>>>() {});
        List<String> itinerary = no.findItinerary(lists);
        System.out.println(itinerary);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // ticket预处理
        for (List<String> ticket : tickets) {
            TreeMap<String, Integer> ends = start2End.computeIfAbsent(ticket.get(0), k -> new TreeMap<>());
            Integer count = ends.getOrDefault(ticket.get(1), 0);
            ends.put(ticket.get(1), count + 1);
        }

        // path预放入起点
        path.add("JFK");

        backTracing(tickets);

        return path;
    }

    private boolean backTracing(List<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) {
            return true;
        }

        // 接下来可能可选的目的地
        TreeMap<String, Integer> ends = start2End.get(path.get(path.size() - 1));
        if (ends == null) {
            return false;
        }
        for (Map.Entry<String, Integer> end : ends.entrySet()) {
            if (end.getValue() <= 0) {
                continue;
            }
            path.add(end.getKey());
            ends.put(end.getKey(), end.getValue() - 1);

            if (backTracing(tickets)) {
                return true;
            }
            ends.put(end.getKey(), end.getValue() + 1);
            path.remove(path.size() - 1);
        }
        return false;
    }
}
