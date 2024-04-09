package programmercarl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Kama54 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String s = sc.nextLine();

        String res = replace(s);
        System.out.println(res);
    }

    private static String replace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                builder.append("number");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}



