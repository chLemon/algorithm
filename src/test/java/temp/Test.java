package temp;

public class Test {

    char c;

    @org.junit.jupiter.api.Test
    public void test() {
        int a = Integer.MAX_VALUE;
        System.out.println(a + 1 > Integer.MAX_VALUE - 2);
        System.out.println(a + 1 >= Integer.MAX_VALUE - 1);
    }

}
