package codinginterviews;

import org.junit.Test;

import java.util.ArrayList;

public class No17 {
    /*
    输入数字 n，
    按顺序打印出从 1 到最大的 n 位十进制数。
    比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     */
    public int[] printNumbers(int n) {
        if (n < 1) {
            return null;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = (int) (max + 9 * Math.pow(10, i));
        }
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }
        return result;

    }

    char[] chars;
    char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    ArrayList<String> resultString;
    int start;
    int n;
    int nine;

    public ArrayList<String> printNumbers2(int n) {
        this.n = n;
        chars = new char[n];
        resultString = new ArrayList<String>();
        start = n - 1;
        dfs(0);
        return resultString;
    }

    void dfs(int index) {
        if (index == n) {
            String s = new String(chars).substring(start);
            if ( s.equals("0")) {return;}
            resultString.add(s);
            if (nine+start==n){
                start--;
            }
            return;
        }
        for (char num : nums) {
            if (num == '9'){nine++;}
            chars[index] = num;
            dfs(index + 1);
        }
        nine--;
    }

    @Test
    public void test() {
        System.out.println(printNumbers2(3).toString());
    }
}
