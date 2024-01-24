package temp;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NoteTest {


    @Test
    @SneakyThrows
    public void test() {
        String dir = "/Users/chen/Nutstore Files/我的坚果云/笔记/计算机相关";
        String f1 = dir + "/JavaSE整理 2021-2-25.md";
        String f2 = dir + "/JavaSE整理.md";

        List<String> f1Lines = Files.readAllLines(Paths.get(f1));
        List<String> f2Lines = Files.readAllLines(Paths.get(f2));

        int start = 0;
        for (int i = 0; i < f1Lines.size(); i++) {
            boolean b = f1Lines.get(i).contains("9 API");
            if (b) {
                start = i;
                break;
            }
        }

        for (int i = 0; i < Math.min(f2Lines.size(), f1Lines.size() - i); i++) {
            String l1 = f1Lines.get(i + start);
            String l2 = f2Lines.get(i);
            if (!l1.equals(l2)) {
                System.out.println("第" + i + "行不一样， l1 : " + l1 + " l2 : " + l2);
            }

        }


    }


}
