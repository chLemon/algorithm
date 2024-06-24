package _solution.codetop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Support {

    static Random random = new Random(System.currentTimeMillis());
    
    public static void main(String[] args) throws IOException {
        random2Problems();

        System.out.println();
        System.out.println();

        List<String> mediums = getAllMediums();
        int i = random.nextInt(mediums.size());
        System.out.println(mediums.get(i));
        int j = random.nextInt(mediums.size());
        System.out.println(mediums.get(j));
    }

    private static void random2Problems() throws IOException {
        Map<String, String> problems = readAllProblems();
        List<String> problemList = new ArrayList<>(problems.keySet());
        int i = random.nextInt(problemList.size());
        System.out.println(problemList.get(i));
        int j = random.nextInt(problemList.size());
        System.out.println(problemList.get(j));
    }

    private static Map<String, String> readAllProblems() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/chen/PersonalGit/algorithm/src/main/java/_solution/codetop/Classic150.md"));
        lines.removeIf(String::isEmpty);
        Map<String, String> problem2Difficulty = new HashMap<>();
        for (int i = 0; i < lines.size(); i += 2) {
            problem2Difficulty.put(lines.get(i), lines.get(i + 1));
        }
        return problem2Difficulty;
    }

    private static List<String> getAllMediums() throws IOException {
        return getAllDifficulty().get("中等");
    }

    private static Map<String, List<String>> getAllDifficulty() throws IOException {
        Map<String, String> problems = readAllProblems();
        Map<String, List<String>> difficulty2Problems = new HashMap<>();
        for (Map.Entry<String, String> entry : problems.entrySet()) {
            difficulty2Problems.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey());
        }
        return difficulty2Problems;
    }


}
