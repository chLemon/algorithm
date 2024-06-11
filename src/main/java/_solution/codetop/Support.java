package _solution.codetop;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Support {

    static List<String> lines;

    public static void main(String[] args) throws Exception {
        lines = Files.readAllLines(Paths.get("/Users/chen/PersonalGit/algorithm/src/main/java/_solution/codetop/需要二刷的题目.md"));
        lines.removeIf(a -> a.equals("```"));
        lines.sort((a, b) -> {
            String a1 = a.split("\\.")[0];
            String b1 = b.split("\\.")[0];
            return Integer.compare(Integer.valueOf(a1), Integer.valueOf(b1));
        });
        for (String line : lines) {
            System.out.println(line);
        }
    }


    private static int count() {
        int count = 0;
        for (String line : lines) {
            if (line.startsWith("##")) count++;
        }
        return count;
    }


    private static int resolveHot100() throws Exception {
        List<String> c150 = Files.readAllLines(Paths.get("/Users/chen/PersonalGit/algorithm/src/main/java/_solution/codetop/Classic150.md"));
        List<String> h100 = Files.readAllLines(Paths.get("/Users/chen/PersonalGit/algorithm/src/main/java/_solution/codetop/Hot100.md"));
        List<String> t255 = Files.readAllLines(Paths.get("/Users/chen/PersonalGit/algorithm/src/main/java/_solution/codetop/top255"));

        Set<String> h100Set = new HashSet<>();
        for (int i = 0; i < h100.size(); i++) {
            if (h100.get(i).isEmpty()) {
                h100Set.add(h100.get(i - 2));
            }
        }
        Set<String> c150Set = new HashSet<>();
        for (int i = 0; i < c150.size(); i++) {
            if (c150.get(i).isEmpty()) {
                c150Set.add(c150.get(i - 2));
            }
        }
        Set<String> t255Set = new HashSet<>();
        for (int i = 0; i < t255.size(); i++) {
            if (t255.get(i).contains(".")) {
                t255Set.add(t255.get(i).split(". ")[1]);
            }
        }
        Set<String> all = new HashSet<>();
        all.addAll(h100Set);
        all.addAll(c150Set);
        all.addAll(t255Set);
        return all.size();
    }
}
