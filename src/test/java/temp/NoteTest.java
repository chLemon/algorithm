package temp;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteTest {
    @Test
    @SneakyThrows
    public void test() {
        
    }

    @Test
    @SneakyThrows
    public void sandTableLogRecord() {
        List<String> fileUrls = new ArrayList<>();
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/account/SuperClassicCaseController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/account/SuperDesignerController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/account/SuperProjectController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/account/SuperTemplateController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/AppVersionController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/AreaValueController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/BuildingShowController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/CoverController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/EbookController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/IconTypeController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/IlluminationController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/IndexController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/LayoutController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/LayoutMaskController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/LayoutNewController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/LoginController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/MapController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/PanoGroupController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/PanoIconController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/PanoramaController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/PanoReleaseController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/ProjectController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/ProjectPlanController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/RoomPanoController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/TagController.java");
        fileUrls.add("/Users/chen/WorkProject/sand-table/code/src/main/java/cn/focus/ecosystem/sand/table/controller/design/account/WanderController.java");

        for (String file : fileUrls) {
            Path path = Paths.get(file);
            List<String> lines = Files.readAllLines(path);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (!line.contains("public Resp<")) {
                    continue;
                }
                // controller方法
                // 往前3行内寻找注解
                List<String> last3 = lines.subList(i - 3, i);
                if (last3.stream().anyMatch(l -> l.contains("@LogRecord"))) {
                    continue;
                }
                if (last3.stream().noneMatch(l -> l.contains("@PostMapping"))) {
                    continue;
                }
                // 有PostMapping，获取ApiOperation里的值
                String apiOperation = last3.stream().filter(l -> l.contains("ApiOperation")).findFirst().orElse("");
                Matcher matcher = Pattern.compile("@ApiOperation\\(\"(.*)\"\\)").matcher(apiOperation);
                if (!matcher.find()) {
                    continue;
                }
                // 内容
                String value = matcher.group(1);
                String lineValue = "@LogRecord(filtered = true, description = \"" + value + "\")";
                lines.add(i, lineValue);
                i++;
            }

            // 文件写回
            Files.write(path, lines);
        }
       
    }


}
