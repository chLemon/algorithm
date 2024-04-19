package programmercarl;

import java.util.*;

class No332 {

    List<String> res = new ArrayList<>();
    Map<String, TreeMap<String, Integer>> port2Ports = new HashMap<>();
    List<List<String>> tickets;

    public static void main(String[] args) {
        No332 no = new No332();
        System.out.println(no.findItinerary(Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        )));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        for (List<String> ticket : tickets) {
            TreeMap<String, Integer> target = port2Ports.computeIfAbsent(ticket.get(0), k -> new TreeMap<>());
            target.merge(ticket.get(1), 1, Integer::sum);
        }

        // 从JFK开始飞行
        dfs("JFK");

        return res;
    }

    private boolean dfs(String start) {
        res.add(start);
        if (res.size() == tickets.size() + 1) {
            return true;
        }

        TreeMap<String, Integer> targets = port2Ports.get(start);
        if (targets == null) {
            return false;
        }

        for (Map.Entry<String, Integer> target : targets.entrySet()) {
            int count = target.getValue();
            if (count > 0) {
                target.setValue(count - 1);

                boolean dfs = dfs(target.getKey());
                if (dfs) return true;

                res.remove(res.size() - 1);
                target.setValue(count);
            }
        }
        return false;
    }

}
