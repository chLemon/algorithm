package offer;

import org.junit.Test;

public class No58_2 {
    /*
    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    请定义一个函数实现字符串左旋转操作的功能。
    比如，输入字符串"abcdefg"和数字2，
    该函数将返回左旋转两位得到的结果"cdefgab"。
     */
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int bias = n%s.length();
        char[] temp = new char[bias];
        for (int i = 0; i < bias; i++) {
            temp[i] = chars[i];
        }
        //前bias个存一下
        for (int i = bias; i < s.length(); i++) {
            chars[i-bias]=chars[i];
        }
        for (int i = s.length()-bias; i < s.length(); i++) {
            chars[i]=temp[i-(s.length()-bias)];
        }
        return new String(chars);
    }
    @Test
    public void test(){
        String s = reverseLeftWords("abcdefg", 2);
        System.out.println(s);
    }
}
