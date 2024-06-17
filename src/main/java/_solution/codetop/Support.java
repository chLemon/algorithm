package _solution.codetop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Support {

    static List<String> lines;

    public static void main(String[] args) throws IOException {
        random2Problems();
    }

//    public static void main(String[] args) throws Exception {
//        //        lines = Files.readAllLines(Paths.get("/Users/chen/PersonalGit/algorithm/src/main/java/_solution/codetop/需要二刷的题目.md"));
//        lines = Files.readAllLines(Paths.get("D:\\JavaProject\\algorithm\\src\\main\\java\\_solution\\codetop\\需要二刷的题目.md"));
//        lines.removeIf(a -> a.contains("```"));
//        lines.sort((a, b) -> {
//            String a1 = a.split("\\.")[0];
//            String b1 = b.split("\\.")[0];
//            return Integer.compare(Integer.valueOf(a1), Integer.valueOf(b1));
//        });
//        for (String line : lines) {
//            System.out.println(line);
//        }
//        System.out.println("合计：" + lines.size());
//    }


    private static void random2Problems() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/chen/PersonalGit/algorithm/src/main/java/_solution/codetop/Classic150.md"));
        lines.removeIf(String::isEmpty);
        List<String> list = Arrays.asList("简单", "中等", "困难");
        lines.removeIf(list::contains);
        Random random = new Random(System.currentTimeMillis());
        int i = random.nextInt(lines.size());
        System.out.println(lines.get(i));
        int j = random.nextInt(lines.size());
        System.out.println(lines.get(j));
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
