package tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class RemoveOneLayerDir {

    public static void main(String[] args) {
        new RemoveOneLayerDir().removeOneLayerDir("D:\\JavaProject\\algorithm\\src\\main\\resources\\Parent");
    }

    private void removeOneLayerDir(String dir) {
        Path basePath = Paths.get(dir);
        File[] subDirs = basePath.toFile().listFiles();
        for (File subDir : subDirs) {
            // 将目录下的每一个文件，移动到basePath下
            if (!subDir.isDirectory()) continue;

            File[] allFile = subDir.listFiles();
            for (File file : allFile) {
                Path newPath = Paths.get(basePath.toString(), file.toPath().getFileName().toString());
                System.out.println(newPath);
                System.out.println(file.toPath());
                try {
                    Files.move(file.toPath(), newPath);
                } catch (Exception ignored) {
                }
            }
            if (subDir.listFiles().length == 0) {
                subDir.delete();
            }
        }
    }

}
