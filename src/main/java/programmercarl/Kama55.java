package programmercarl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Kama55 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int k = sc.nextInt();
        String s = sc.next();
        String res = rotate(s, k);
        System.out.println(res);
    }

    private static String rotate(String s, int k) {
        k = k % s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, k - 1);
        reverse(chars, k, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

}
