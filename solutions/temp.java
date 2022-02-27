import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class temp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer input=1;

        while (input  != 0) {
            try {
                input = sc.nextInt();
            } catch (Exception e) {
            }
            System.out.println(calNum(input));
        }
    }

    public static int calNum(int n) {
        int result = 0;
        while ((n / 3) != 0) {
            result += n / 3;
            n = n / 3 + n % 3;
        }
        if (n == 2) {
            result++;
        }
        return result;
    }
}