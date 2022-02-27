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
        String res = complexNumberMultiply("78+-76i", "-86+72i");
        
    }

    public String complexNumberMultiply(String num1, String num2) {
        int plusIndex1 = num1.indexOf("+");
        String solid1Str = num1.substring(0, plusIndex1);
        int solid1;
        if (solid1Str.charAt(0) == '-') {
            solid1 = -Integer.parseInt(solid1Str.substring(1, solid1Str.length()));
        } else {
            solid1 = Integer.parseInt(solid1Str);
        }
        String vitual1Str = num1.substring(plusIndex1 + 1, num1.length());
        int vitual1;
        if (vitual1Str.charAt(0) == '-') {
            vitual1 = -Integer.parseInt(vitual1Str.substring(1, vitual1Str.length() - 1));
        } else {
            vitual1 = Integer.parseInt(vitual1Str.substring(0, vitual1Str.length() - 1));
        }


        int plusIndex2 = num2.indexOf("+");
        String solid2Str = num2.substring(0, plusIndex2);
        int solid2;
        if (solid2Str.charAt(0) == '-') {
            solid2 = -Integer.parseInt(solid2Str.substring(1, solid2Str.length()));
        } else {
            solid2 = Integer.parseInt(solid2Str);
        }
        String vitual2Str = num2.substring(plusIndex2 + 1, num2.length());
        int vitual2;
        if (vitual2Str.charAt(0) == '-') {
            vitual2 = -Integer.parseInt(vitual2Str.substring(1, vitual2Str.length() - 1));
        } else {
            vitual2 = Integer.parseInt(vitual2Str.substring(0, vitual2Str.length() - 1));
        }

        int resSolid = solid1 * solid2 - vitual1 * vitual2;
        int resVirtual = solid1 * vitual2 + vitual1 * solid2;

        return resSolid + "+" + resVirtual + "i";
    }
}