import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class test {

    @Test
    public void test() {
        List<Long> tes1 = new ArrayList<>();
        tes1.add(1000000000L);
        tes1.add(1000000001L);
        tes1.add(100000002L);
        tes1.add(10000003L);


        Long aLong = new Long("1000000000");
        System.out.println(tes1.contains(aLong));
    }
}