package temp;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isUpperCase;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5Test {


    // Combine operations to prevent code duplication:
    Stream<DynamicTest> testVersions(String id,
                                     Function<StringInverter, String> test) {
        List<StringInverter> versions = Arrays.asList(
                new Inverter1(), new Inverter2(),
                new Inverter3(), new Inverter4());
        return DynamicTest.stream(
                versions.iterator(),
                inverter -> inverter.getClass().getSimpleName(),
                inverter -> {
                    System.out.println(inverter.getClass().getSimpleName() + ": " + id);
                    try {
                        if (test.apply(inverter) != "fail")
                            System.out.println("Success");
                    } catch (Exception | Error e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                });
    }

    String isEqual(String lval, String rval) {
        if (lval.equals(rval))
            return "success";
        System.out.println("FAIL: " + lval + " != " + rval);
        return "fail";
    }

    @TestFactory
    Stream<DynamicTest> basicInversion1() {
        String in = "Exit, Pursued by a Bear.";
        String out = "eXIT, pURSUED BY A bEAR.";
        return testVersions("Basic inversion (should succeed)",
                inverter -> isEqual(inverter.invert(in), out)
        );
    }

    @TestFactory
    Stream<DynamicTest> basicInversion2() {
        return testVersions("Basic inversion (should fail)",
                inverter -> isEqual(inverter.invert("X"), "X"));
    }

    @TestFactory
    Stream<DynamicTest> disallowedCharacters() {
        String disallowed = ";-_()*&ˆ%$#@!~`0123456789";
        return testVersions(
                "Disallowed characters",
                inverter -> {
                    String result = disallowed.chars()
                            .mapToObj(c -> {
                                String cc = Character.toString((char) c);
                                try {
                                    inverter.invert(cc);
                                    return "";
                                } catch (RuntimeException e) {
                                    return cc;
                                }
                            }).collect(Collectors.joining(""));
                    if (result.length() == 0)
                        return "success";
                    System.out.println("Bad characters: " + result);
                    return "fail";
                }
        );
    }

    @TestFactory
    Stream<DynamicTest> allowedCharacters() {
        String lowcase = "abcdefghijklmnopqrstuvwxyz ,.";
        String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
        return testVersions(
                "Allowed characters (should succeed)",
                inverter -> {
                    assertEquals(inverter.invert(lowcase), upcase);
                    assertEquals(inverter.invert(upcase), lowcase);
                    return "success";
                }
        );
    }

    @TestFactory
    Stream<DynamicTest> lengthNoGreaterThan30() {
        String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertTrue(str.length() > 30);
        return testVersions(
                "Length must be less than 31 (throws exception)",
                inverter -> inverter.invert(str)
        );
    }

    @TestFactory
    Stream<DynamicTest> lengthLessThan31() {
        String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertTrue(str.length() < 31);
        return testVersions(
                "Length must be less than 31 (should succeed)",
                inverter -> inverter.invert(str)
        );
    }
}

interface StringInverter {
    String invert(String str);
}

class Inverter1 implements StringInverter {
    public String invert(String str) {
        return str;
    }
}

class Inverter2 implements StringInverter {
    public String invert(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += isUpperCase(c) ?
                    toLowerCase(c) :
                    toUpperCase(c);
        }
        return result;
    }
}

class Inverter3 implements StringInverter {
    public String invert(String str) {
        if (str.length() > 30)
            throw new RuntimeException("argument too long!");
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += isUpperCase(c) ?
                    toLowerCase(c) :
                    toUpperCase(c);
        }
        return result;
    }
}

class Inverter4 implements StringInverter {
    static final String ALLOWED = "abcdefghijklmnopqrstuvwxyz ,." + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String invert(String str) {
        if (str.length() > 30)
            throw new RuntimeException("argument too long!");
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (ALLOWED.indexOf(c) == -1)
                throw new RuntimeException(c + " Not allowed");
            result += isUpperCase(c) ?
                    toLowerCase(c) :
                    toUpperCase(c);
        }
        return result;
    }
}
