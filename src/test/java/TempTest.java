import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class TempTest {

    @Test
    public void test() {
        String s = "![abc]";

        System.out.println(Pattern.compile("!\\[\\S+].*").matcher(s).matches());
    }
}
